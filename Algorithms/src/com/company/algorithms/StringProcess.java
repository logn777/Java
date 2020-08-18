package com.company.algorithms;

public class StringProcess {

    /**
     * Кодирование длин серий (англ. run-length encoding, RLE) или кодирование повторов
     * @param str строка для сжатия
     * @return новая обработанная строка
     */
    public static String getRLE(String str)
    {
        if (str == null || str.equals(""))
        {
            return str;
        }
        char currentChar = str.charAt(0);
        int currentCharCount = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= str.length(); i++)
        {
            char c = i < str.length() ? str.charAt(i) : 0;
            if (i == str.length() || currentCharCount == 9 || c != currentChar)
            {
                sb.append(currentChar);
                if (currentCharCount > 1)
                {
                    sb.append((char)(currentCharCount + '0'));
                }
                currentCharCount = 1;
                currentChar = c;
            }
            else
            {
                currentCharCount++;
            }
        }
        return sb.toString();
    }

    /**
     * Функция возвращает кол-во слов во входной строке
     *
     * @param source - исходня строка
     * @return целое число - колическто слов с втроке
     */
    public int getWordsCount(String source){
        int count = 0;

        if(source.length() != 0){
            count++;
            //Проверяем каждый символ, не пробел ли это
            for (int i = 0; i < source.length(); i++) {
                if(source.charAt(i) == ' '){
                    //Если пробел - увеличиваем количество слов на 1
                    count++;
                }
            }
        }
        return count;
    }
}
