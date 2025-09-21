fun formatNumber(number: Int): String {
    return when {
        number < 1000 -> number.toString()
        number < 10000 -> {
            val thousands = number / 1000
            val hundreds = (number % 1000) / 100
            if (hundreds > 0) "$thousands.${hundreds}K" else "${thousands}K"
        }
        number < 1000000 -> "${number / 1000}K"
        else -> {
            val millions = number / 1000000
            val hundredThousands = (number % 1000000) / 100000
            if (hundredThousands > 0) "$millions.${hundredThousands}M" else "${millions}M"
        }
    }
}