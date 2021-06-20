package com.company;

//интерфейс и класс телефона для 380V
interface ChargerFor380V {
    void charge380V();
}

class PhoneFor380V implements ChargerFor380V {
    public void charge380V() {
        System.out.println("Заряжается от 380V");
    }
}

//класс генератора выдающего 380V
class Generator {
    private ChargerFor380V charger;

    public Generator(ChargerFor380V charger) {
        this.charger = charger;
    }

    public void charge() {
        charger.charge380V();
    }
}

//интерфейс и класс телефона для 220V
interface ChargerFor220V {
    void charge220V();
}

class PhoneFor220V implements ChargerFor220V {
    public void charge220V() {
        System.out.println("Заряжается от 220V");
    }
}

// адаптер для зарядки 220V
class ChargerAdapter implements ChargerFor380V {
    private ChargerFor220V charger;

    public ChargerAdapter(ChargerFor220V charger) {
        this.charger = charger;
    }

    public void charge380V() {
        charger.charge220V();
    }
}

public class PatternAdapter {
    public static void main(String[] args) {
        PhoneFor380V phoneFor380V = new PhoneFor380V();
        Generator generator = new Generator(phoneFor380V);
        generator.charge();

        PhoneFor220V phoneFor220V = new PhoneFor220V();
        ChargerAdapter chargerAdapterWithPhoneFor220V = new ChargerAdapter(phoneFor220V);
        Generator generatorWorkWith220V = new Generator(chargerAdapterWithPhoneFor220V);
        generatorWorkWith220V.charge();
    }
}
