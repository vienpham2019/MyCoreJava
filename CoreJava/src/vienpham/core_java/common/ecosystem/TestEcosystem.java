package vienpham.core_java.common.ecosystem;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import vienpham.core_java.common.animal.*;
import vienpham.core_java.common.animal.fish.*;

public class TestEcosystem {

	public static void main(String...args) {
		
		
		PelagicOcean ocean = new PelagicOcean(); 
		ocean.findNearbyAnimals();
		ocean.greateWhiteSharkAreHungry();
		
	}

}
