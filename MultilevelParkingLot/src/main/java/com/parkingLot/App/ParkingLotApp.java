package com.parkingLot.App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.parkingLot.ParkingTicket;
import com.parkingLot.Util.Constants;
import com.parkingLot.Vehicle.Car;
import com.parkingLot.Vehicle.Color;
import com.parkingLot.service.ParkingLotService;
import com.parkingLot.service.ParkingLotServiceImpl;

/**
 * Main Parking lot app class that allows you to input the data to interact with
 * parking lot.It can run in two ways interactive and file driven.If file name
 * is provided as an input argument that it will use that file name and run the
 * parking lot functionalities using commands present in that file name.Else if
 * we run it interactive mode than as user provides the comaands it executes
 * them immediately and returns back the result.
 * 
 * @author srawat1
 *
 */
public class ParkingLotApp {

	public static void analyzeAndProcessInputString(String inputStr, ParkingLotService lot) {
		if (null != inputStr) {
			if (inputStr.contains(Constants.PARK_CAR_STRING)) {
				String[] parkArr = inputStr.split(Constants.SPACE);
				ParkingTicket ticket = lot.parkVehicle(new Car(parkArr[1].trim(), Color.valueOf(parkArr[2].trim())));
				if (ticket != null) {
					System.out.println(ticket);
				} else {
					System.out.println("Sorry, parking lot is full");
				}

			} else if (inputStr.contains(Constants.CREATE_PARKING_LOT_STRING)) {
				String numOfSlots = inputStr.trim().substring(Constants.CREATE_PARKING_LOT_STRING.length(),
						inputStr.trim().length());
				lot.initParkingLot(Integer.valueOf(numOfSlots.trim()));

			} else if (inputStr.contains(Constants.LEAVE_PARKING_STRING)) {
				String[] leaveParkArr = inputStr.split(Constants.SPACE);
				lot.removeVehicle(Integer.parseInt(leaveParkArr[1].trim()));

			} else if (inputStr.contains(Constants.REG_NUM_VIA_COLOR_STRING)) {
				String[] regNumViaColor = inputStr.split(Constants.SPACE);
				lot.getRegNumOfAllCarsFromColor(Color.valueOf(regNumViaColor[1].trim()));

			} else if (inputStr.contains(Constants.SLOT_NO_VIA_COLOR_STRING)) {
				String[] slotNumViaColor = inputStr.split(Constants.SPACE);
				lot.getAllSlotNumberFromColor(Color.valueOf(slotNumViaColor[1].trim()));

			} else if (inputStr.contains(Constants.STATUS_PARKING_LOT_STRING)) {
				lot.printStatus();

			} else if (inputStr.contains(Constants.SLOT_NUM_VIA_REG_STRING)) {
				String[] slotNumViaReg = inputStr.split(Constants.SPACE);
				lot.getSlotNumberFromRegNum(slotNumViaReg[1].trim());
			}
		}

	}

	public static void main(String args[]) throws IOException {
		ParkingLotService lot = new ParkingLotServiceImpl();
		if (args.length > 0) {
			String fileName = args[0];
			File file = new File(fileName);
			FileReader fr = null;
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				analyzeAndProcessInputString(line.trim(), lot);
			}
			br.close();
		} else {
			startInteractiveSession(lot);
		}

	}

	public static void startInteractiveSession(ParkingLotService lot) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String line = sc.nextLine().trim();
			if (line.toLowerCase().equals("exit"))
				break;
			analyzeAndProcessInputString(line, lot);
		}
		sc.close();
	}

}
