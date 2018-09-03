package _05BarracksWarsReturnOfTheDependencies;


import _05BarracksWarsReturnOfTheDependencies.contracts.Repository;
import _05BarracksWarsReturnOfTheDependencies.contracts.UnitFactory;
import _05BarracksWarsReturnOfTheDependencies.core.Engine;
import _05BarracksWarsReturnOfTheDependencies.core.factories.UnitFactoryImpl;
import _05BarracksWarsReturnOfTheDependencies.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
