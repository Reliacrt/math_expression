package parser.producer;

public class Transformer {

    /*<E extends Enum<E>> Function<String, List<Token<E>>>
            rawStringToTokenListProducer(EnumMap<E, String> map) {
        return string -> {
            val regexCollection = Op.mapToList(map.values(),
                    str -> "(" + str + ")");
            val regex = String.join("|", regexCollection);
            val scanner = new Scanner(string);
            val stringBuilder = new StringBuilder();
            val list = new ArrayList<Token<E>>();
            while (scanner.hasNext()) {
                String item = scanner.findInLine(regex);
                if (item == null) {
                    throw new IllegalWordException();
                }
                stringBuilder.append(item);
                for (var entry : map.entrySet()) {
                    if (item.matches(entry.getValue())) {
                        list.add(new Token<>(entry.getKey(), item));
                        break;
                    }
                }
            }
            if (!stringBuilder.toString().equals(string)) {
                throw new IllegalWordException();
            }
            return list;
        };
    }*/
}
