package com.rad.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class intervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(0, 2));
		intervals.add(new Interval(13, 15));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(4, 7));
		intervals.add(new Interval(8, 9));
		intervals.add(new Interval(9, 12));
		Collections.sort(intervals);
		System.out.println(intervals);
		System.out.println(mergeInterval(intervals));
	}

	// Merge all overlapping intervals
	static List<Interval> mergeInterval(List<Interval> intervalList) {
		List<Interval> result = new ArrayList<>();
		Interval previous = intervalList.get(0);
		for (int i = 1; i < intervalList.size(); i++) {
			Interval current = intervalList.get(i);
			System.out.println(current);
			if (previous.end >= current.start) {
				Interval newInt = new Interval(previous.start, 
						Math.max(current.end, previous.end));
				previous=newInt;

			} else {
				result.add(previous);
				previous = current;
			}
		}
		result.add(previous);
		return result;
	}

}

class Interval implements Comparable {
	int start;
	int end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int compareTo(Object o) {
		if (o instanceof Interval) {
			return this.start - ((Interval) o).start;
		}
		return Integer.MAX_VALUE;
	}

	public String toString() {
		return "Interval start: " + this.start + " end: " + this.end + "\n";
	}

}
