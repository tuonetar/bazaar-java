package com.jc;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Entry {

	public static double add(double a, double b) {
		System.out.println("The result of " + a + " + " + b + " is " + (a + b));
		return (a + b);
	}
	
	public static double sub(double a, double b) {
		System.out.println("The result of " + a + " - " + b + " is " + (a - b));
		return (a - b);
	}
	
	public static double mul(double a, double b) {
		System.out.println("The result of " + a + " * " + b + " is " + (a * b));
		return (a * b);
	}
	
	public static double div(double a, double b) {
		if (b == 0) {
			System.out.println("I don't know how to divide by 0");
			return (0);
		}
		System.out.println("The result of " + a + " / " + b + " is " + (a / b));
		return (a / b);
	}
	
	public static double mod(double a, double b) {
		if (b == 0) {
			System.out.println("I don't know how to divide by 0");
			return (0);
		}
		System.out.println("The result of " + a + " % " + b + " is " + (a % b));
		return (a % b);
	}
	
	public static void		calculatorUsage() {
		System.out.println("Usage : Enter a number, an operator and a second number.");
		System.out.println("You can iterate on the result with another operator and number.");
		System.out.println("Use 'C' to clean your answer and 'S' to quit.");
	}
	
	public static void calculator(String[] args) {
		
		// EXERCICE Calculette V1, 2, 3
		
		Scanner sc = new Scanner(System.in);
		double	a;
		double	b;
		char	op;
		boolean	calculating;
		String	input;
		
		calculatorUsage();
		
		calculating = true;
		try {
			a = sc.nextDouble();
			
			while (calculating) {
				op = sc.next().charAt(0);
				if (op == 'C') {
					a = 0;
					System.out.println("Reintialising value.");
					continue;
				} else if (op == 'S') {
					calculating = false;
					System.out.println("Thank you for using our stuff. Your final value is " + a);
					break;
				}
				input = sc.next();
				if (input.contains("C")) {
					op = 'C';
				}
				b = Double.parseDouble(input.substring(1));
				switch (op) {
					case '+':
						a = add(a, b);
						break;
					case '-':
						a = sub(a, b);
						break;
					case '*':
						a = mul(a, b);
						break;
					case '/':
						a = div(a, b);
						break;
					case '%':
						a = mod(a, b);
						break;
					default:
						System.out.println("Unknown operation type.");
						break;
				}
				System.out.println("Current answer : " + a);
			}
		} catch (Exception e) {
			System.out.println("Please learn to input actual numbers.");
		}
		
		sc.close();
	}
	
	public static void exercice1() {
		// EXERCICE 1
		// Ecrire un algorithme permettant d?????changer les valeurs de deux variables A et B, 
		// et ce quel que soit leur contenu pr??alable.
		int a;
		int b;
		
		a = 7;
		b = 9;
		
		// Solution 1
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + " " + b);
		
		// Solution 2
		int c = b;
		b = a;
		a = c;
		System.out.println(a + " " + b);
	}
	
	public static void exercice2() {
		// EXERCICE 2.1
		// ??crire un programme qui demande un nombre ?? l???utilisateur,
		// puis qui calcule et affiche le carr?? de ce nombre.
		
		int		num;
		Scanner	sc = new Scanner(System.in);
		
		sc.useLocale(Locale.US);
		try {
			num = sc.nextInt();
		} catch (Exception e) {
			num = 42;
		}
		System.out.println(Math.pow(num, 2));
		
		
		// EXERCICE 2.2
		// ??crire un programme qui lit le prix HT d???un article,
		// le nombre d???articles et le taux de TVA, et qui fournit le
		// prix total TTC correspondant.
		// Faire en sorte que des libell??s apparaissent clairement.
		
		double	price;
		int		articleQuantity;
		double	tva;
		
		try {
			price = sc.nextDouble();
			articleQuantity = sc.nextInt();
			tva = sc.nextDouble() / 100 + 1.0;
		} catch (Exception e) {
			System.out.println("So it appears you don't know how to write a number.");
			price = 42;
			articleQuantity = 42;
			tva = 42.42;
		}
		System.out.println("Prix total HT : " + price * articleQuantity
				+ "??? ; prix total TTC : " + (price * tva * articleQuantity) + "???");
		
		sc.close();
	}
	
	public static void exercice3() {
		// Some 'global' utility variables.
		Scanner sc = new Scanner(System.in);
		String errNaN = "This does not appear to be a number.";
		
		sc.useLocale(Locale.US);
		
		// EXERCICE 3.1
		// ??crire un algorithme qui demande un nombre ?? l???utilisateur,
		// et l???informe ensuite si ce nombre est positif ou n??gatif
		// (on laisse de c??t?? le cas o?? le nombre vaut z??ro).

		double	a;
		
		System.out.println("EXERCICE 3.1 : Input a numbers and I'll tell you things.");
		try {
			a = sc.nextDouble();
			if (a > 0) {
				System.out.println("Your number is positive.");
			} else if (a < 0) {
				System.out.println("Your number is negative.");
			}
		} catch (Exception e) {
			System.out.println(errNaN);
		}
		
		// EXERCICE 3.2
		// ??crire un algorithme qui demande deux nombres ?? l???utilisateur et
		// l???informe ensuite si leur produit est n??gatif ou positif (on laisse de c??t?? le cas o?? le produit est nul). 
		// Attention toutefois : on ne doit pas calculer le produit des deux nombres.
		

		double	b;
		double	c;
		
		System.out.println("EXERCICE 3.2 : Input two numbers and I'll tell you things.");
		try {
			b = sc.nextDouble();
			c = sc.nextDouble();
			if ((b > 0 && c > 0) || (b < 0 && c < 0)) {
				System.out.println("The product of those number is positive.");
			} else if (b != 0 && c != 0) {
				System.out.println("The product of those number is negative.");
			}
		} catch (Exception e) {
			System.out.println(errNaN);
		}
		
		// EXERCICE 3.3
		// ??crire un algorithme qui demande l?????ge d???un enfant ?? l???utilisateur. Ensuite, il l???informe de sa cat??gorie :
		// "Poussin" de 6 ?? 7 ans
		// "Pupille" de 8 ?? 9 ans
		// "Minime" de 10 ?? 11 ans
		// "Cadet" apr??s 12 ans
		
		int age;
		String category;
		
		System.out.println("EXERCICE 3.3 : Entrez l'age de votre enfant pour l'inscrire chez les scouts.");
		try {
			age = sc.nextInt();
			if (age < 6) {
				System.out.println("Vraiment ?");
			} else {
				switch (age) {
					case 6, 7:
						category = "Poussin";
						break;
					case 8, 9:
						category = "Pupille";
						break;
					case 10, 11:
						category = "Minime";
						break;
					default:
						category = "Cadet";
						break;
				}
				System.out.println("Votre enfant appartient ?? la cat??gorie : " + category);
			}
			
		} catch (Exception e) {
			System.out.println(errNaN);
		}
		
		sc.close();
	}
	
	public static void soon(int hours, int minutes) {
		minutes++;
		if (minutes >= 60) {
			hours++;
			minutes = 0;
			if (hours >= 24) {
				hours = 0;
			}
		}
		System.out.println("Dans une minute, il sera " + hours + " heure(s) " + minutes);
	}

	public static void exercice4() {
		// Cet algorithme est destin?? ?? pr??dire l'avenir, et il doit ??tre infaillible !
		// Il lira au clavier l???heure et les minutes, et il affichera 
		// l???heure qu???il sera une minute plus tard. Par exemple, si l'utilisateur
		// tape 21 puis 32, l'algorithme doit r??pondre :
		// "Dans une minute, il sera 21 heure(s) 33".
		// NB : on suppose que l'utilisateur entre une heure valide.
		// Pas besoin donc de la v??rifier. Faire une fonction qui prend en param??tre l???heure et les minutes
		
		Scanner	sc = new Scanner(System.in);
		int		hours;
		int		minutes;
		 
		hours = sc.nextInt();
		minutes = sc.nextInt();
		soon(hours, minutes);
		 
		sc.close();
	}
	
	public static void exercice5() {
		// Some 'global' utility variables.
		Scanner	sc;
		int		i;
		
		// EXERCICE 5.2
		// ??crire un algorithme qui demande un nombre compris entre 10 et 20,
		// jusqu????? ce que la r??ponse convienne. En cas de r??ponse sup??rieure ?? 20,
		// on fera appara??tre un message : ?? Plus petit ! ??, et inversement,
		// ?? Plus grand ! ?? si le nombre est inf??rieur ?? 10.
		int		userNumber;
		int		goal;
		
		goal = (int)(Math.random() * 10 + 10);
		//System.out.println(goal);
		userNumber = 0;		
		do {
			System.out.print("Entez un nombre entre 10 et 20. Inclus.> ");

			try {
				sc = new Scanner(System.in);

				userNumber = sc.nextInt();
				sc.close();
				
			} catch (Exception e) {
				System.out.println("Je ne peux pas te laisser faire cela, Dave.");
				continue;
			}
			if (userNumber < 10) {
				System.out.println("Plus grand !");
			} else if (userNumber > 20) {
				System.out.println("Plus petit !");
			}
		} while (userNumber != goal);
		
		// EXERCICE 5.3
		// ??crire un algorithme qui demande un nombre de d??part, et qui ensuite ??crit
		// la table de multiplication de ce nombre. (Merci de la pr??senter comme
		// l???exemple o?? l'utilisateur entre le nombre 7) :
		// Table de 7 :
		// 7 x 1 = 7
		// 7 x 2 = 14
		// 7 x 3 = 21
		// ???
		// 7 x 10 = 70
		int		userMultTable;
		String	MultiplicationLine;
		
		sc = new Scanner(System.in);
		System.out.print("Quelle table de multiplication n'??tes vous pas capable de calculer ?> ");
		userMultTable = 0;	
		try {
			userMultTable = sc.nextInt();
			System.out.println("Table de " + userMultTable + " :");
			for (i = 1; i <= 10; ++i) {
				MultiplicationLine = String.format("%d x %d = %d", userMultTable, i, userMultTable * i);
				System.out.println(MultiplicationLine);
			}
		} catch (Exception e) {
			System.out.println("Je ne peux pas te laisser faire cela, Dave.");
		}
				
		sc.close();
	}
		
	public static void	exerciceBig() {
		// ??crire un algorithme qui demande successivement 10 nombres ?? l???utilisateur.  Le programme lui ressortira ensuite le plus grand. 
		// Entrez le nombre num??ro 1 : 12
		// Entrez le nombre num??ro 2 : 14
		// ...
		// Entrez le nombre num??ro 10 : 6
		// Le plus grand nombre saisi est : 14
		// Modifier ensuite l???algorithme pour que le programme affiche de surcro??t la position du nombre le plus grand. 
		// La position du nombre le plus grand est : 2e nombre saisi.
		Scanner	sc;
		int		i;
		int		biggest;
		int		bigPosition;
		int		userEntry;
		
		biggest = 0;
		bigPosition = -1;
		for (i = 1; i <= 10; i++) {
			System.out.print("Entrez le nombre num??ro " + i + " : ");
			try {
				sc = new Scanner(System.in);
				userEntry = sc.nextInt();
				// Boucle infinie si je d??commente...Scanner est nul.
				// sc.close();
			} catch (Exception e) {
				System.out.println("NaN"); i--;
				continue;
			}
			if (bigPosition == -1 ||biggest < userEntry) {
				biggest = userEntry;
				bigPosition = i;
			}
		}
		System.out.println("Le plus grand nombre saisi est : " + biggest);
		System.out.println("La position du nombre le plus grand est : " + bigPosition + "e nombre saisi.");
	}
	
	public static int[]	generateSomeIntArray(int length) {
		int		randomArray[];
		int		i;
		
		randomArray = new int[length];
		for (i = 0; i < randomArray.length; i++) {
			randomArray[i] = (int) (Math.random() * 1000);
		}
		return randomArray;
	}
	
	public static void	exercice6() {
		// EXERCICE 6.1
		// Ecrire un algorithme qui d??clare et remplit un tableau de
		// 6 valeurs num??riques en les mettant toutes ?? 15.
		
		int		arrFifteen[];
		int		i;
		
		System.out.println("===> EXERCICE 6.1 <===");
		
		// Solution 1
		arrFifteen = new int[6];
		for (i = 0; i < arrFifteen.length; i++) {
			arrFifteen[i] = 15;
		}
		// Solution 2
		Arrays.fill(arrFifteen, 15);
		System.out.println(Arrays.toString(arrFifteen));

		// EXERCICE 6.2
		// Ecrire un algorithme qui d??clare un tableau de 5 notes.
		// L'utilisateur devra ensuite saisir les valeurs, au clavier.
		
		String	userNotes[];
		Scanner	sc;

		System.out.println("===> EXERCICE 6.2 <===");
		
		userNotes = new String[5];
		for (i = 0; i < userNotes.length; i++) {
			try {
				System.out.print("Notez quelque chose >");
				sc = new Scanner(System.in);
				userNotes[i] = sc.nextLine();
				//sc.close();
			} catch (Exception e) {
				System.out.println("Tu ne sais pas ??crire cela, John Snow.");
				i--;
				continue;
			}
		}
		System.out.println(Arrays.toString(userNotes));
		
		// EXERCICE 6.3
		// Ecrire un algorithme calculant la somme des valeurs
		// d'un tableau (on suppose que le tableau a ??t?? pr??alablement initialis??)
		
		// Note : Possibilit?? de Over/Underflow.

		int		someNumbers[];
		int		sum;

		System.out.println("===> EXERCICE 6.3 <===");
		
		sum = 0;
		someNumbers = generateSomeIntArray(20);
		for (i = 0; i < someNumbers.length; i++) {
			sum += someNumbers[i];
		}
		System.out.println(Arrays.toString(someNumbers));
		System.out.println("La Somme est : " + sum);
		
		// EXERCICE 6.4
		// Ecrire un algorithme constituant un tableau, ?? partir de
		// deux tableaux de m??me longueur pr??alablement initialis??s.
		// Le nouveau tableau sera la somme des ??l??ments des deux tableaux de d??part.
		
		int		firstArray[];
		int		secondArray[];
		int		sumArray[];

		System.out.println("===> EXERCICE 6.4 <===");
		
		firstArray = generateSomeIntArray(10);
		secondArray = generateSomeIntArray(10);
		if (firstArray.length != secondArray.length) {
			System.out.println("Les tableaux n'on pas la m??me taille.");
		} else {
			sumArray = new int[firstArray.length];
			for (i = 0; i < firstArray.length; i++) {
				sumArray[i] = firstArray[i] + secondArray[i];
			}

			System.out.println(Arrays.toString(firstArray));
			System.out.println(Arrays.toString(secondArray));
			System.out.println(Arrays.toString(sumArray));
		}
		
	}
	
	public static void main(String[] args) {
//		exercice1();
//		exercice2();
//		exercice3();
//		exercice4();
//		exercice5();
//		exerciceBig();
//		exercice6();
	}
}
