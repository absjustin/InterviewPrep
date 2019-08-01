package com.liuxin.interview.map;

import java.util.Arrays;
import java.util.HashMap;

public class TimeMap {
    HashMap<String, MappedValue> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        ValueWithTS val = new ValueWithTS();
        val.timestamp = timestamp;
        val.value = value;
        if (map.containsKey(key)) {
            MappedValue vals = map.get(key);
            vals.vals[vals.next] = val;
            vals.next++;
        } else {
            MappedValue newValue = new MappedValue();
            newValue.vals[0] = val;
            newValue.next = 1;
            map.put(key, newValue);
        }
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            MappedValue value = map.get(key);
            Arrays.sort(value.vals);
            ValueWithTS lookupKey = new ValueWithTS();
            lookupKey.timestamp = timestamp;
            int index = Arrays.binarySearch(value.vals, lookupKey);
            if (index == value.next) {
                return "";
            } else {
                return value.vals[index].value;
            }
        } else {
            return "";
        }
    }

    private class MappedValue {
        ValueWithTS[] vals;
        int next;
    }

    private class ValueWithTS implements Comparable {
        String value;
        int timestamp;

        @Override
        public int compareTo(Object o) {
            if (o instanceof ValueWithTS) {
                return Integer.compare(this.timestamp, ((ValueWithTS) o).timestamp);
            }
            throw new ClassCastException();
        }
    }
}
