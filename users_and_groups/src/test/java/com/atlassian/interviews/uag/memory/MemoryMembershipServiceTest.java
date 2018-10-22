package com.atlassian.interviews.uag.memory;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.atlassian.interviews.uag.api.Group;
import com.atlassian.interviews.uag.api.GroupService;
import com.atlassian.interviews.uag.api.MembershipService;
import com.atlassian.interviews.uag.api.User;
import com.atlassian.interviews.uag.core.ServiceFactory;
import com.atlassian.interviews.uag.core.Services;

public class MemoryMembershipServiceTest {
	private static final User FRED = new User("fred");
	private static final User GEORGE = new User("george");
	private static final User NOBODY = new User("nobody");
	private static final Group HACKERS = new Group("hackers");
	private static final Group ADMINS = new Group("admins");
	private static final Group NOGROUP = new Group("nogroup");

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private MembershipService membershipService;
	private GroupService groupService;

	@Before
	public void setUp() {
		final Services services = ServiceFactory.createServices();
		services.getUserService().create(FRED);
		services.getUserService().create(GEORGE);
		services.getGroupService().create(ADMINS);
		services.getGroupService().create(HACKERS);
		membershipService = services.getMembershipService();
		groupService = services.getGroupService();
	}

	@Test
	public void addUserToGroup_duplicate() {
		membershipService.addUserToGroup(FRED, HACKERS);
		membershipService.addUserToGroup(GEORGE, HACKERS);

		final Set<User> expected = new HashSet<>();
		expected.add(FRED);
		expected.add(GEORGE);
		assertEquals(asList(FRED, GEORGE), sorted(membershipService.getUsersInGroup(HACKERS)));

		membershipService.addUserToGroup(FRED, HACKERS);
		assertEquals(asList(FRED, GEORGE), sorted(membershipService.getUsersInGroup(HACKERS)));
	}

	@Test
	public void addUserToGroup_noSuchGroup() {
		thrown.expect(IllegalArgumentException.class);
		membershipService.addUserToGroup(FRED, NOGROUP);
	}

	@Test
	public void addUserToGroup_noSuchUser() {
		thrown.expect(IllegalArgumentException.class);
		membershipService.addUserToGroup(NOBODY, HACKERS);
	}

	@Test
	public void addUserToGroup_npeGroup() {
		thrown.expect(NullPointerException.class);
		membershipService.addUserToGroup(FRED, null);
	}

	@Test
	public void addUserToGroup_npeUser() {
		thrown.expect(NullPointerException.class);
		membershipService.addUserToGroup(null, HACKERS);
	}

	@Test
	public void testRemoveUserFromGroup() {
		membershipService.addUserToGroup(FRED, ADMINS);
		membershipService.addUserToGroup(GEORGE, HACKERS);
		assertTrue("fred is an admin", membershipService.isUserInGroup(FRED, ADMINS));

		membershipService.removeUserFromGroup(FRED, ADMINS);
		assertFalse("fred is not an admin anymore", membershipService.isUserInGroup(FRED, ADMINS));
	}

	@Test
	public void testIsUserInGroup_no() {
		membershipService.addUserToGroup(FRED, ADMINS);
		membershipService.addUserToGroup(GEORGE, HACKERS);

		assertFalse("fred is not a hacker", membershipService.isUserInGroup(FRED, HACKERS));
		assertFalse("george is not an admin", membershipService.isUserInGroup(GEORGE, ADMINS));
	}

	@Test
	public void testIsUserInGroup_yes() {
		membershipService.addUserToGroup(FRED, ADMINS);
		membershipService.addUserToGroup(GEORGE, HACKERS);

		assertTrue("fred is an admin", membershipService.isUserInGroup(FRED, ADMINS));
		assertTrue("george is a hacker", membershipService.isUserInGroup(GEORGE, HACKERS));
	}

	@Test
	public void testRemoveUserFromGroup_whenDoesntExist() {
		membershipService.removeUserFromGroup(FRED, ADMINS);
	}

	@Test
	public void testGroupCreation() {
		membershipService.addUserToGroup(FRED, ADMINS);
		groupService.delete(ADMINS);
		groupService.create(ADMINS);
		assertTrue("group is empty", membershipService.getUsersInGroup(ADMINS).isEmpty());
	}

	@Test
	public void testUserRemovalFromGroup() {
		// User in group
		membershipService.addUserToGroup(FRED, ADMINS);

		assertTrue("fred is an admin", membershipService.isUserInGroup(FRED, ADMINS));
		membershipService.removeUserFromGroup(FRED, ADMINS);
		assertFalse("fred is not an admin anymore", membershipService.isUserInGroup(FRED, ADMINS));

		assertFalse("george is not an admin", membershipService.isUserInGroup(GEORGE, ADMINS));
		membershipService.removeUserFromGroup(GEORGE, HACKERS);
		assertFalse("george is not an admin", membershipService.isUserInGroup(GEORGE, ADMINS));
	}

	private static <T extends Comparable<T>> List<T> sorted(Collection<T> items) {
		final List<T> list = new ArrayList<>(items);
		Collections.sort(list);
		return list;
	}
}