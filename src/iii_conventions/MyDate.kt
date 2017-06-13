package iii_conventions

import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) {
    operator fun compareTo(other: MyDate): Int
            = Date(year, month, dayOfMonth).compareTo(Date(other.year, other.month, other.dayOfMonth))

    operator fun plus(amount: TimeInterval): MyDate {
        return this.addTimeIntervals(amount, amount.times)
    }

    operator fun plus(repeatedTimeInterval: RepeatedTimeInterval): MyDate {
        return this.addTimeIntervals(repeatedTimeInterval.ti, repeatedTimeInterval.n)
    }

}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval(var times: Int = 1) {
    DAY,
    WEEK,
    YEAR;

    operator fun times(i: Int): RepeatedTimeInterval {
        return RepeatedTimeInterval(this, i)
    }
}

class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)


class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(date: MyDate): Boolean {
        return start < date && date < endInclusive
    }

    operator fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {

            var item = start

            override fun hasNext(): Boolean = item <= endInclusive

            override fun next(): MyDate {
                val t = item
                item = item.nextDay()
                return t
            }
        }
    }
}
