package code.shubham.codegen;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Field {
    String source;
    String destination;
    String defaultExpression;
}
