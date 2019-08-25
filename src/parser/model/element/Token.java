package parser.model.element;

import lombok.Data;
import lombok.Getter;
import parser.model.characteristic.Reducible;

@Data
public class Token<E extends Enum<E>> implements Reducible {
    @Getter private final E type;
    @Getter private final String Value;
}
