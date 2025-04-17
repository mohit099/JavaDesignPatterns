package b_structure;

import java.util.HashMap;
import java.util.Map;

interface Character {
    void display(int fontSize);
}

class ConcreteCharacter implements Character{

    private char symbol;

    ConcreteCharacter(char symbol){
        this.symbol = symbol;
    }

    @Override
    public void display(int fontSize) {
        System.out.println("Displaying '"+symbol+"' at fontSize: "+fontSize);
    }
}


class CharacterFactory{

    private static final Map<java.lang.Character,Character> charMap= new HashMap<>();
    public static Character getCharacter(char symbol) {
        return charMap.computeIfAbsent(symbol, ConcreteCharacter::new);
    }
}



public class Flyweight {

    public static void main(String[] args) {
        Character charA = CharacterFactory.getCharacter('A');
        charA.display(14);

        Character charB = CharacterFactory.getCharacter('B');
        charB.display(14);

        charA.display(16);

    }
}
