package com.atlassian.interviews.uag.memory;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.ParametersAreNonnullByDefault;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.interviews.uag.api.Group;
import com.atlassian.interviews.uag.api.MembershipService;
import com.atlassian.interviews.uag.api.User;
import com.atlassian.interviews.uag.core.AbstractService;
import com.atlassian.interviews.uag.core.Services;

/**
 * An implementation of the membership service that stores user and group
 * relationships in memory.
 */
@ParametersAreNonnullByDefault
public class MemoryMembershipService extends AbstractService implements MembershipService {
	private static final Logger LOG = LoggerFactory.getLogger(MemoryMembershipService.class);

	private final Map<Group, Set<Group>> childGroupsByParent = new HashMap<>();
	private final Map<Group, Set<User>> usersByGroup = new HashMap<>();

	public MemoryMembershipService(Services services) {
		super(services);
	}

	@Override
	public void addGroupToGroup(Group child, Group parent) {
		requireExists(parent);
		requireExists(child);

		Set<Group> children = childGroupsByParent.get(parent);
		if (children == null) {
			children = new HashSet<>();
			childGroupsByParent.put(parent, children);
		}
		children.add(child);

		LOG.debug("Added child group " + child + " to parent group " + parent);
	}

	public void addUserToGroup(User user, Group group) {
		requireExists(user);
		requireExists(group);

		Set<User> users = usersByGroup.get(group);
		if (users == null) {
			users = new HashSet<>();
			usersByGroup.put(group, users);
		}
		users.add(user);

		LOG.debug("Added user " + user + " to group " + group);
	}

	public boolean isUserInGroup(User user, Group group) {
		requireNonNull(user, "user");
		requireNonNull(group, "group");
		boolean returnFlag = false;
		// TODO... Only knows direct memberships right now
		Set<User> users = (Set<User>) getUsersInGroup(group);
		if (users != null) {
			returnFlag = returnFlag || users.contains(user);
			if (returnFlag) {
				return returnFlag;
			}
		}
		Collection<Group> children = childGroupsByParent.get(group);
		if (null != children) {
			for (Group group2 : children) {
				returnFlag = returnFlag || isUserInGroup(user, group2);
				if (returnFlag) {
					return returnFlag;
				}
			}
		}

		return returnFlag;
	}

	public boolean isGroupInGroup(Group child, Group parent) {
		requireNonNull(child, "child");
		requireNonNull(parent, "parent");
		boolean returnFlag = false;
		// TODO... Only doing one level for now
		Collection<Group> children = childGroupsByParent.get(parent);
		returnFlag = returnFlag || (children != null && children.contains(child));
		if (returnFlag) {
			return returnFlag;
		}
		if (null != children) {
			for (Group group2 : children) {
				returnFlag = returnFlag || isGroupInGroup(child, group2);
				if (returnFlag) {
					return returnFlag;
				}
			}
		}
		return returnFlag;
	}

	public Collection<User> getUsersInGroup(Group group) {
		requireNonNull(group, "group");

		final Collection<User> users = usersByGroup.get(group);
		if (users == null) {
			ArrayList<User> users1 = new ArrayList<>();
			return users1;
		}
		LOG.debug("Current users in group {}: {}", group.toString(), users.toString());
		return users;
	}

	@Override
	public void removeGroupFromGroup(Group child, Group parent) {
		requireNonNull(parent, "parent");
		requireNonNull(child, "child");

		Set<Group> children = childGroupsByParent.get(parent);
		if (children != null) {
			children.remove(child);
		}
	}

	public void removeUserFromGroup(User user, Group group) {
		requireNonNull(user, "user");
		requireNonNull(group, "group");
		removeUserFromGroupUtil(user, group);
		LOG.debug(String.format("Removed user %s from group %s", user, group));
	}

	private boolean removeUserFromGroupUtil(User user, Group group) {
		boolean returnFlag = false;
		Collection<User> users = getUsersInGroup(group);
		if (null != users) {
			returnFlag = returnFlag || users.remove(user);
		}
		if (returnFlag) {
			return returnFlag;
		}
		Collection<Group> children = childGroupsByParent.get(group);
		if (null != children) {
			for (Group group2 : children) {
				returnFlag = returnFlag || removeUserFromGroupUtil(user, group2);
				if (returnFlag) {
					return returnFlag;
				}
			}
		}
		return returnFlag;
	}

	private void requireExists(User user) {
		requireNonNull(user, "user");
		if (services.getUserService().findByName(user.getName()) == null) {
			throw new IllegalArgumentException("User '" + user + "' does not exist!");
		}
	}

	private void requireExists(Group group) {
		requireNonNull(group, "group");
		if (services.getGroupService().findByName(group.getName()) == null) {
			throw new IllegalArgumentException("Group '" + group + "' does not exist!");
		}
	}

	public void emptyGroup(Group group) {
		usersByGroup.put(group, new HashSet<User>());
	}
}
