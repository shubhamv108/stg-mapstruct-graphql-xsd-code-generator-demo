package code.shubham.codegen;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class STGCodeGenerator {
    public void execute(String... args) throws IOException {

        TransformerConfiguration configuration = TransformerConfiguration.builder()
                .name("AuthorTransformer")
                .fields(List.of(Field.builder().source("name").destination("source.name").build()))
                .source("code.shubham.client.graphql.models.Author")
                .destination("generated.Shiptotype")
                .outputDirectory("build/generated/sources/annotationProcessor/java/main/code/shubham/transformers")
                .build();

        final STGroup stGroup = new STGroupFile("transformer.stg");

        final ST template = stGroup.getInstanceOf("transformer");
        template.add("transformer_name", configuration.getName());
        template.add("source", configuration.getSource());
        template.add("destination", configuration.getDestination());
        template.add("fields", configuration.getFields());

        final String render = template.render();

        Files.createDirectories(configuration.getAbsoluteOutputJavaFilePath().getParent());
        if (!Files.exists(configuration.getAbsoluteOutputJavaFilePath()))
            Files.createFile(configuration.getAbsoluteOutputJavaFilePath());
        Files.write(configuration.getAbsoluteOutputJavaFilePath(), render.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
    }
}
