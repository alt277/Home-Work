package ru.gbyte.multy_brackets;

class CheckBracket {
    private String input;
                                  /* Постарался здесь выполнить усложненную задачу проверки ввода
                                     разных видов скобок и учета приоритета их ввода.
                                     Прирритет ввода: 1)   {}
                                                      2)   ()
                                                      3)   []
                                   */
    public CheckBracket(String in) {

        input = in;
    }

    public void check() {

        int stackSize = input.length();

        Stack stackForLeftSymbols = new Stack(stackSize);

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);

            switch (ch) {
                case '{':      // Открывающие скобки
                case '[':
                case '(':

                    if (!stackForLeftSymbols.isEmpty())  // Если стек не пуст,
                    {
                        char previous = stackForLeftSymbols.pop();
                        if (ch == '{' && (previous == '(')             // проверка приоритета скобок
                                || ch == '(' && (previous == '[')
                                || ch == '{' && (previous == '[')
                        )
                            System.out.println("Error open: нельзя ставить " + previous + " перед " + ch
                                    + "  в позиции: " + j);

                        stackForLeftSymbols.push(previous);
                        stackForLeftSymbols.push(ch);
                    } else {

                        stackForLeftSymbols.push(ch);
                    }
                    break;

                case '}':      // Закрывающие скобки
                case ']':
                case ')':

                    if (!stackForLeftSymbols.isEmpty()) {
                        char chx = stackForLeftSymbols.pop();

                        if ((ch == '}' && chx != '{') ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '(')
                        ) {
                            System.out.println("Error: не парные скобки  " + ch + " at " + j);
                        }
                    } else                                                  // Стек пуст
                        System.out.println("Error: Лишние правые скобки " + ch + " at " + j);
                    break;

                default:
                    break;
            }
        }
        if (!stackForLeftSymbols.isEmpty())
            System.out.println("Error:   Лишние левые скобки");
    }
}
