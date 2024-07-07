package midterm.nikoloz_naskidashvili_1.task1;


public class Fantasy extends AbstractFantasy implements Dream {
    private final String studentName = "Nikoloz Naskidashvili";

    public String getSuitcase1() {
        return studentName + "'s suitcase";
    }

    public String getDigital2() {
        return studentName + "'s digital";
    }

    public String methodAlgorithm3(String argCaucasus5) {
        return studentName + "'s algorithm";
    }

    public java.util.List<String> methodBird4(String argSandpaper6) {
        return java.util.Collections.emptyList();
    }

    public String toString() {
        String result = "";

        result += getSuitcase1() + "\n";
        result += getDigital2() + "\n";
        result += methodAlgorithm3("argCaucasus5") + "\n";
        result += methodBird4("argSandpaper6") + "\n";
        return result;
    }
}
