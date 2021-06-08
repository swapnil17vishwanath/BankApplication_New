package com.springboot.bankapplication.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.uuid.Generators;

public class BankUtility {

	public static Long bankAccountNoCreator() {
		Long accountNumber = null;
		UUID timeBasedUUID = Generators.timeBasedGenerator().generate();

		/*
		 * coverting UUID to long using node method
		 */
		accountNumber = UUID.fromString(timeBasedUUID.toString()).node();
		return accountNumber;
	}

	public static List<LocalDateTime> convertMonthIntoDate(String month, String year) {

		ArrayList<LocalDateTime> dateList = new ArrayList<>();
		String startDate = null;
		String endDate = null;
		String startTime=" 00:00:00";
		String endTime=" 23:59:59";

		if (month.equalsIgnoreCase("January") || month.equalsIgnoreCase("Jan")) {
			startDate = year + "-01-01";
			endDate = year + "-01-31";
		} else if (month.equalsIgnoreCase("February") || month.equalsIgnoreCase("Feb")) {
			startDate = year + "-02-01";
			endDate = year + "-02-28";
		} else if (month.equalsIgnoreCase("March") || month.equalsIgnoreCase("Mar")) {
			startDate = year + "-03-01";
			endDate = year + "-03-31";
		} else if (month.equalsIgnoreCase("April") || month.equalsIgnoreCase("Apr")) {
			startDate = year + "-04-01";
			endDate = year + "-04-30";
		} else if (month.equalsIgnoreCase("May")) {
			startDate = year + "-05-01";
			endDate = year + "-05-31";
		} else if (month.equalsIgnoreCase("June") || month.equalsIgnoreCase("Jun")) {
			startDate = year + "-06-01";
			endDate = year + "-06-30";
		} else if (month.equalsIgnoreCase("July") || month.equalsIgnoreCase("Jul")) {
			startDate = year + "-07-01";
			endDate = year + "-07-31";
		} else if (month.equalsIgnoreCase("August") || month.equalsIgnoreCase("Aug")) {
			startDate = year + "-08-01";
			endDate = year + "-08-31";
		} else if (month.equalsIgnoreCase("September") || month.equalsIgnoreCase("Sept")) {
			startDate = year + "-09-01";
			endDate = year + "-09-30";
		} else if (month.equalsIgnoreCase("October") || month.equalsIgnoreCase("Oct")) {
			startDate = year + "-10-01";
			endDate = year + "-10-31";
		} else if (month.equalsIgnoreCase("November") || month.equalsIgnoreCase("Nov")) {
			startDate = year + "-11-01";
			endDate = year + "-11-30";
		} else if (month.equalsIgnoreCase("December") || month.equalsIgnoreCase("Dec")) {
			startDate = year + "-12-01";
			endDate = year + "-12-31";
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		dateList.add(LocalDateTime.parse(endDate+endTime,formatter));
		dateList.add(LocalDateTime.parse(startDate+startTime,formatter));
		return dateList;
		
	}
}
