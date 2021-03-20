package by.bsuir.oop.labs.first;

import by.bsuir.oop.labs.first.shapes.AbstractShape;

import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleLoader {

    public static void main(String[] args) {
        Path pluginsDir = Paths.get("plugins");
        ModuleFinder pluginsFinder = ModuleFinder.of(pluginsDir);

        List<String> plugins = pluginsFinder
                .findAll()
                .stream()
                .map(ModuleReference::descriptor)
                .map(ModuleDescriptor::name)
                .collect(Collectors.toList());

        Configuration pluginsConfiguration = ModuleLayer
                .boot()
                .configuration()
                .resolve(pluginsFinder, ModuleFinder.of(), plugins);

        ModuleLayer layer = ModuleLayer
                .boot()
                .defineModulesWithOneLoader(pluginsConfiguration, ClassLoader.getSystemClassLoader());

        List<AbstractShape> abstractShapes = AbstractShape.getServices(layer);
        for (AbstractShape shape : abstractShapes) {
            System.out.println(shape.getClass());
        }

    }

}
