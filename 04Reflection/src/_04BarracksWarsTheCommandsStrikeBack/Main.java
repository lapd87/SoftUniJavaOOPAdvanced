package _04BarracksWarsTheCommandsStrikeBack;


import _04BarracksWarsTheCommandsStrikeBack.contracts.Repository;
import _04BarracksWarsTheCommandsStrikeBack.contracts.UnitFactory;
import _04BarracksWarsTheCommandsStrikeBack.core.Engine;
import _04BarracksWarsTheCommandsStrikeBack.core.factories.UnitFactoryImpl;
import _04BarracksWarsTheCommandsStrikeBack.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
