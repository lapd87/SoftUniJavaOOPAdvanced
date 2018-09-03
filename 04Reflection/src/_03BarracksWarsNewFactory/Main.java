package _03BarracksWarsNewFactory;


import _03BarracksWarsNewFactory.contracts.Repository;
import _03BarracksWarsNewFactory.contracts.UnitFactory;
import _03BarracksWarsNewFactory.core.Engine;
import _03BarracksWarsNewFactory.core.factories.UnitFactoryImpl;
import _03BarracksWarsNewFactory.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
