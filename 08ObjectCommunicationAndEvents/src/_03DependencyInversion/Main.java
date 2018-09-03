package _03DependencyInversion;

import _03DependencyInversion.contracts.Strategy;
import _03DependencyInversion.enums.OperandType;
import _03DependencyInversion.models.PrimitiveCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * Created by IntelliJ IDEA.
 * User: LAPD
 * Date: 5.8.2018 г.
 * Time: 12:49 ч.
 */
public class Main {

    private static final String STRATEGIES_REFERENCE_PATH = "_03DependencyInversion.models.strategies.";
    private static final String STRATEGIES_DIRECTORY_PATH = System.getProperty("user.dir")
            + "/src/_03DependencyInversion/models/strategies";
    private static final String JAVA_FILE_SUFFIX_REGEX = ".java$";
    private static final String STRATEGY_SUFFIX = "Strategy";


    public static void main(String[] args)
            throws IOException,
            IllegalAccessException,
            InstantiationException,
            ClassNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        PrimitiveCalculator primitiveCalculator = new PrimitiveCalculator();

        String input;
        while (true) {
            if ("End".equals(input = bufferedReader.readLine())) {
                break;
            }

            String[] commandArgs = input.split("\\s+");

            String command = commandArgs[0];

            switch (command) {
                case "mode":
                    primitiveCalculator
                            .changeStrategy(
                                    getStrategy(commandArgs[1]));
                    break;
                default:
                    int firstOperand = Integer
                            .parseInt(commandArgs[0]);
                    int secondOperand = Integer
                            .parseInt(commandArgs[1]);

                    System.out.println(primitiveCalculator
                            .performCalculation(firstOperand,
                                    secondOperand));
            }
        }
    }

//    private static Strategy getStrategy(String strategySign)
//            throws ClassNotFoundException,
//            IllegalAccessException,
//            InstantiationException {
//        File strategiesDirectory = new File(STRATEGIES_DIRECTORY_PATH);
//
//        if (!strategiesDirectory.isDirectory()) {
//            return null;
//        }
//
//        File[] strategyFiles = strategiesDirectory.listFiles();
//
//        if (strategyFiles == null) {
//            return null;
//        }
//
//        List<String> strategiesClassNames = new ArrayList<>();
//        for (File strategyFile : strategyFiles) {
//            String strategyFileName = strategyFile
//                    .getName();
//            String strategyClassName = strategyFileName
//                    .replaceAll(JAVA_FILE_SUFFIX_REGEX, "");
//
//            strategiesClassNames.add(strategyClassName);
//        }
//
//        for (String strategyName : strategiesClassNames) {
//            Class strategyClass = Class
//                    .forName(STRATEGIES_REFERENCE_PATH + strategyName);
//
//            Annotation[] annotations = strategyClass.getAnnotations();
//
//            for (Annotation annotation : annotations) {
//                if (annotation instanceof CalculationMode) {
//                    CalculationMode calculationMode = (CalculationMode) annotation;
//
//                    if (calculationMode.value().equals(strategySign)) {
//                        return (Strategy) strategyClass
//                                .newInstance();
//                    }
//                }
//            }
//        }
//        return null;
//    }

    private static Strategy getStrategy(String strategySign)
            throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {

        OperandType operandType = Arrays.stream(OperandType.values())
                .filter(v -> v.getOperandType().equals(strategySign))
                .findFirst()
                .orElse(null);

        String strategyName = STRATEGIES_REFERENCE_PATH
                + operandType
                + STRATEGY_SUFFIX;

        return (Strategy) Class.forName(strategyName)
                .newInstance();
    }
}