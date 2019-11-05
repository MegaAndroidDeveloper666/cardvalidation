package ru.markstudio.cardvalidation

class CardValidator {

    companion object {
        fun validate(cardNumber: String): Boolean {
            return simpleValidate(cardNumber) && lyhnValidate(cardNumber)
        }

        private fun simpleValidate(cardNumber: String): Boolean {
            if (cardNumber.isEmpty()) {
                return false
            }

            if (!cardNumber.matches(Regex("[0-9]+"))) {
                return false
            }

            if (cardNumber[0] == '0') {
                return false
            }

            if (cardNumber.length !in 12..19) {
                return false
            }

            return true
        }

        private fun lyhnValidate(cardNumber: String): Boolean {
            val digitList = cardNumber.map { ch -> ch.toInt() }.toMutableList()
            for (i in digitList.indices step 2) {
                var value = digitList[i] * 2
                if (value > 9) {
                    value -= 9
                }
                digitList[i] = value
            }
            return digitList.sum() % 10 == 0
        }

    }

}