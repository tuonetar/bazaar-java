package stupiddungeon;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import ajc.basics.Orc;

public class OrcHandling {
	static Scanner sc = new Scanner(System.in);

	public static String greeting() {
		return "Starting up OMP v.0.2...";
	}
	
	public static void help() {
		System.out.println("Help will not come.");
	}
	
	public static String farewell() {
		return "Ending the Orc Mining programm. All Orc will be freed.";
	}
	
	/*
	 * @throws RuntimeException
	 */
	public static boolean creatingOrc(Map<String, Orc> mine) throws RuntimeException {
		String	fledgeName;
		int		fledgeStrength;
		int		fledgeHP;
		
		if (mine.size() >= 2)
			throw new RuntimeException("There cannot be more than two orcs in that mine.");
		
		System.out.println("We shall create new Orcs");
		try {
			System.out.println("Name ?");
			fledgeName = sc.next();
			System.out.println("Strength ?");
			fledgeStrength = Integer.parseInt(sc.next());
			System.out.println("Hit Point ?");
			fledgeHP = Integer.parseInt(sc.next());
			mine.put(fledgeName, new Orc(fledgeName, fledgeHP, fledgeStrength));
			System.out.println("Orc has been created today.");
		} catch (NumberFormatException e) {
			System.err.println("This is not a number, try again.");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("No Orc has been created today.");
		}
		return true;
	}
	
	public static void killingOrc(Map<String, Orc> mine) {
		String	sacrifice;

		System.out.println("Who shall die ?");
		try {
			sacrifice = sc.next();
		} catch (Exception e) {
			System.err.println("Some input issue. Try again.");
			e.printStackTrace();
			return ;
		}
		if (mine.containsKey(sacrifice)) {
			mine.remove(sacrifice);
			System.out.println("Orc " + sacrifice + " has been killed."
					+ mine.size() + " orcs remaining.");
		} else {
			System.err.println("There is no such Orc within our ranks. Would you like to create one ?");
		}
	}
	
	public static void	inspectMine(Map<String, Orc> mine) {
		if (mine.size() == 0) {
			System.err.println("The production has yet to birth orcs.");
			return;
		}
		System.out.format("The mine has birthed %d orcs. Those orcs are :", mine.size());
		for (String orcName : mine.keySet()) {
			System.out.println(mine.get(orcName));
		}
		System.out.println(mine.entrySet().stream().mapToInt(orc -> orc.getValue().getForce()).sum());

	}
	
	public static void	howStrong(Map<String, Orc> mine) {
		int		totalStrength;
		
		totalStrength = 0;
		for (String key : mine.keySet()) {
			totalStrength += mine.get(key).getForce();
		}
		System.out.println("Our army has a strength of " + totalStrength);
	}
	
	public static void	countHobbits() {
		System.out.println("The hobbits have yet to be taken to Isengard.");
	}
	
	public static void main(String[] args) {
        Map<String, Runnable>	commands;
		boolean					active;
		Map<String, Orc>		orcMine;
		String					userEntry;

		active = true;
		commands = new HashMap<>();
		orcMine = new HashMap<String, Orc>();
		commands.put("create", () -> creatingOrc(orcMine));
		commands.put("delete", () -> killingOrc(orcMine));
		commands.put("check", () -> howStrong(orcMine));
		commands.put("inspect", () -> inspectMine(orcMine));
		commands.put("hobbits", () -> countHobbits());
		commands.put("help", () -> help());
		commands.put("q", () -> System.exit(0));
		
		System.out.println(greeting());
		do {
			try {
				System.out.print(">");
				userEntry = sc.next();
				if (userEntry.equals("quit"))
					active = false;
				else if (commands.containsKey(userEntry))
					try {
						commands.get(userEntry).run();
					} catch (Exception e) {
						System.err.println(e.getMessage());
						System.err.println("This is an exceptionnal exception handling.");
					}
			} catch (Exception e) {
				System.err.println("Scanner did die again.");
				e.printStackTrace();
				active = false;
			}
		} while (active);
		System.out.println(farewell());
		orcMine.clear();
		sc.close();
	}
}
