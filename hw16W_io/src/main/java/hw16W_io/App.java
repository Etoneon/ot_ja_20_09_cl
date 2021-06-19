package hw16W_io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import hw16W_io.dataprocessor.FileLoader;
import hw16W_io.dataprocessor.ProcessorAggregator;
import hw16W_io.dataprocessor.FileSerializer;

public class App {

    public static void main(String[] args) throws java.io.IOException {

        String pathCurrent = System.getProperty("user.dir");
        System.out.println("current dir: " + pathCurrent);

        // !!!  чтобы работал Апп, надо положить джисон в ресурсы
/*

        //given
        var inputDataFileName = "inputData.json";
        var outputDataFileName = "outputData.json";
        var fullOutputFilePath = String.format("%s%s%s",pathCurrent, File.separator, outputDataFileName);

        var loader = new FileLoader(inputDataFileName);

        var processor = new ProcessorAggregator();
        var serializer = new FileSerializer(fullOutputFilePath);

        //when
        var loadedMeasurements = loader.load();
        var aggregatedMeasurements = processor.process(loadedMeasurements);

        serializer.serialize(aggregatedMeasurements);

        //then

        System.out.println(".isEqualTo(9) :" + loadedMeasurements.size());
        System.out.println(".isEqualTo(3) :" +aggregatedMeasurements.entrySet().size());

        System.out.println("aggregatedMeasurements :" +aggregatedMeasurements);

        var serializedOutput = Files.readString(Paths.get(fullOutputFilePath));
        //обратите внимание: важен порядок ключей
        System.out.println(" isEqualTo(\"{\\\"val1\\\":3.0,\\\"val2\\\":30.0,\\\"val3\\\":33.0}\")" +"\n"+ serializedOutput);
*/
    }

}
