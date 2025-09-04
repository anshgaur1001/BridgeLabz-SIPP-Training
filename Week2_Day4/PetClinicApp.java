import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

// Pet class (Encapsulation)
class Pet {
    private String name;
    private String species;
    private LocalDate lastVaccinationDate;

    public Pet(String name, String species, LocalDate lastVaccinationDate) {
        this.name = name;
        this.species = species;
        this.lastVaccinationDate = lastVaccinationDate;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public LocalDate getLastVaccinationDate() {
        return lastVaccinationDate;
    }

    // Method to check vaccination status
    public String checkVaccinationStatus() {
        LocalDate today = LocalDate.now();
        Period diff = Period.between(lastVaccinationDate, today);
        int months = diff.getYears() * 12 + diff.getMonths();

        if (months > 12) {
            return "Vaccination OVERDUE! Please vaccinate immediately.";
        } else if (months == 11) {
            return "Vaccination due in 1 month. Reminder set.";
        } else {
            return "Vaccination up-to-date.";
        }
    }

    @Override
    public String toString() {
        return "Pet: " + name + " | Species: " + species + " | Last Vaccination: " + lastVaccinationDate;
    }
}

// Clinic Manager Class
class ClinicManager {
    private List<Pet> pets;

    public ClinicManager() {
        pets = new ArrayList<>();
    }

    public void registerPet(Pet p) {
        pets.add(p);
        System.out.println("Registering " + p.toString());
        System.out.println("Status: " + p.checkVaccinationStatus());
    }
}

// Main Class (Simulation)
public class PetClinicApp {
    public static void main(String[] args) {
        ClinicManager clinic = new ClinicManager();

        // Day 1
        Pet bruno = new Pet("Bruno", "Dog", LocalDate.of(2024, 10, 12));
        clinic.registerPet(bruno);

        // Day 2
        Pet mittens = new Pet("Mittens", "Cat", LocalDate.of(2023, 6, 15));
        clinic.registerPet(mittens);

        // Day 3
        Pet snowy = new Pet("Snowy", "Rabbit", LocalDate.of(2024, 9, 10));
        clinic.registerPet(snowy);
    }
}
