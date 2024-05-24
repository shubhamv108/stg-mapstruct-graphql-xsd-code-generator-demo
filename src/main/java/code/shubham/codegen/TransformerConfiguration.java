package code.shubham.codegen;

import lombok.Builder;
import lombok.Getter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class TransformerConfiguration {

    String name;
    String source;
    String destination;

    @Builder.Default
    List<Field> fields = new ArrayList<>();
    String outputDirectory;

    public Path getAbsoluteOutputJavaFilePath() {
        return Paths.get(System.getProperty("user.dir"), outputDirectory, name + ".java");
    }
}
