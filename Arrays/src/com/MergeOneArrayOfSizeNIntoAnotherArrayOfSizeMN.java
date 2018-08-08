package com;

import java.util.Arrays;

public class MergeOneArrayOfSizeNIntoAnotherArrayOfSizeMN {


	public static void main(String[] args) {
		int NA = -1;
		int mPlusN[] = { 2, 8, NA, NA, NA, 13, NA, 15, 20 };
		int N[] = { 5, 7, 9, 25 };
		int j = mPlusN.length - 1;
		int k = 0;
		for (int i = mPlusN.length - 1; i > 0; i--) {
			if (mPlusN[i] != NA)
				mPlusN[j--] = mPlusN[i];
			else
				mPlusN[j--] = N[k++];
		}
		Arrays.sort(mPlusN);

		for (int i = 0; i < mPlusN.length; i++)
			System.out.print(mPlusN[i] + " ::" + " \t ");
	}
}
