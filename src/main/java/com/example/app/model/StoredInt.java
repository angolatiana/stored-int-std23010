package com.example.app.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

public class StoredInt {
    private final String file_path = "/tmp/stored-int.txt";

    public String getStoredInt() {
        File file = new File(file_path);

        try {
            if (file.exists()) {
                // Lire le contenu du fichier existant
                return Files.readString(file.toPath()).trim();
            } else {
                // Créer le fichier et y écrire un entier aléatoire
                int randomInt = new Random().nextInt(10000); // entre 0 et 9999
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(Integer.toString(randomInt));
                }
                return Integer.toString(randomInt);
            }
        } catch (IOException e) {
            throw new RuntimeException("Erreur de lecture/écriture sur stored-int.txt", e);
        }
    }
}
