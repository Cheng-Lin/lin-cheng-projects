package resources;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NamesResource {
	private static Random ranGen = new Random();

	public static String getRandomLastName() {
		return lastNames[ranGen.nextInt(lastNames.length)];
	}

	public static String getRandomFirstName() {
		String name = "";
		if(Math.random() > 0.5) {
			name = maleFirstNames[ranGen.nextInt(maleFirstNames.length)];
		} else {
			name = femaleFirstNames[ranGen.nextInt(femaleFirstNames.length)];			
		}
		return name;
	}

	public static String getRandomMaleFirstName() {
		return maleFirstNames[ranGen.nextInt(maleFirstNames.length)];
	}

	public static String getRandomFeMaleFirstName() {
		return femaleFirstNames[ranGen.nextInt(femaleFirstNames.length)];
	}

	public static String getRandomID() {
		String id = "";
		long L;
		L = Math.abs(ranGen.nextLong())%1000000000;
		if (L < 100000000) {
			id = "0" + L;
		} else {
			id = "" + L;
		}
		return id;
	}

	public static String[] getRandomBirthPlace() {
		String[] retVal = new String[2];
		int i = ranGen.nextInt(capitalsList.size());
		retVal[0] = capitalsList.get(i);
		retVal[1] = capitals.get(retVal[0]);
		return retVal;
	}

	public static Date getRandomBirthDate() {
		long M;
		M = Math.abs(ranGen.nextLong());
		// capital letter M for readability
		Date date = new Date();
		long today = date.getTime();
		date.setTime(M % today);
		return date;
	}

	/**
	 * This method will generate an array of random Date objects,
	 * given certain parameters. The years parameter indicates
	 * which years to use and the howMany parameter indicates 
	 * how many of each year to put into the output. The intention 
	 * is that if N = years.length, then N = howMany.length. 
	 * The number of Dates in the output will be:
	 * howMany[0]+howMany[1]+...+howMany[N]. 
	 * If years.length and howMany.length are different
	 * the extra elements will be ignored and the output
	 * will be shorter.
	 * Example: 
	 * int[] y = {1990, 1989, 1987};
	 * int[] num = {2, 2, 3};
	 * Date[] dates = NamesResource.getDateArray(y, num);
	 * This code will make an array of length 7 consisting of 
	 * 2 dates from 1990, 2 dates from 1989 and 3 dates from 1987.
	 * NOTE: the method throws NullPointerException if either
	 * array parameter is null.
	 * @param years array of years for the random dates
	 * @param howMany array giving gthe number of each year 
	 * to create  
	 * @return array of random Dates with the given 
	 * distribution of years
	 */
	public static Date[] getDateArray(int[] years, int[] howMany) {
		long randLong;
		Random ranGen = new Random();
		int len = Math.min(years.length, howMany.length);
		int numDates = 0; 
		for(int i = 0; i < len; i++) {
			numDates += howMany[i];
		}
		Date[] retVal = new Date[numDates];
		int index = 0;
		for(int i = 0; i < len; i++) {
			for(int j = 0; j < howMany[i]; j++) {
				randLong = Math.abs(ranGen.nextLong());
				// create a date as right now 
				Date date = new Date();
				long nowMillSecs = date.getTime();
				// change date to a random date in
				// the past:
				date.setTime(randLong % nowMillSecs);
				Calendar cal = Calendar.getInstance();
				// set the Calendar to the random Date
				cal.setTime(date);
				// change the year to the one desired:
				cal.set(Calendar.YEAR, years[i]);
				retVal[index++] = cal.getTime();
			}
		}
		return retVal;
	}

	// Thanks to the mongabay website and the links:	
	// http://names.mongabay.com/1000.html
	// http://names.mongabay.com/male_names.htm
	// http://names.mongabay.com/female_names.htm
	// The 1000 most common last names in the USA
	private static String[] lastNames = {"Smith", "Johnson",
		"Williams", "Brown", "Jones", "Miller",
		"Davis", "Garcia", "Rodriguez", "Wilson",
		"Martinez", "Anderson", "Taylor", "Thomas",
		"Hernandez", "Moore", "Martin", "Jackson",
		"Thompson", "White", "Lopez", "Lee", "Gonzalez",
		"Harris", "Clark", "Lewis", "Robinson", "Walker",
		"Perez", "Hall", "Young", "Allen", "Sanchez",
		"Wright", "King", "Scott", "Green", "Baker",
		"Adams", "Nelson", "Hill", "Ramirez", "Campbell",
		"Mitchell", "Roberts", "Carter", "Phillips",
		"Evans", "Turner", "Torres", "Parker", "Collins",
		"Edwards", "Stewart", "Flores", "Morris", "Nguyen",
		"Murphy", "Rivera", "Cook", "Rogers", "Morgan",
		"Peterson", "Cooper", "Reed", "Bailey", "Bell",
		"Gomez", "Kelly", "Howard", "Ward", "Cox", "Diaz",
		"Richardson", "Wood", "Watson", "Brooks", "Bennett",
		"Gray", "James", "Reyes", "Cruz", "Hughes", "Price",
		"Myers", "Long", "Foster", "Sanders", "Ross",
		"Morales", "Powell", "Sullivan", "Russell",
		"Ortiz", "Jenkins", "Gutierrez", "Perry",
		"Butler", "Barnes", "Fisher", "Henderson",
		"Coleman", "Simmons", "Patterson", "Jordan",
		"Reynolds", "Hamilton", "Graham", "Kim", "Gonzales",
		"Alexander", "Ramos", "Wallace", "Griffin", "West",
		"Cole", "Hayes", "Chavez", "Gibson", "Bryant",
		"Ellis", "Stevens", "Murray", "Ford", "Marshall",
		"Owens", "Mcdonald", "Harrison", "Ruiz", "Kennedy",
		"Wells", "Alvarez", "Woods", "Mendoza", "Castillo",
		"Olson", "Webb", "Washington", "Tucker", "Freeman",
		"Burns", "Henry", "Vasquez", "Snyder", "Simpson",
		"Crawford", "Jimenez", "Porter", "Mason", "Shaw",
		"Gordon", "Wagner", "Hunter", "Romero", "Hicks",
		"Dixon", "Hunt", "Palmer", "Robertson", "Black",
		"Holmes", "Stone", "Meyer", "Boyd", "Mills",
		"Warren", "Fox", "Rose", "Rice", "Moreno",
		"Schmidt", "Patel", "Ferguson", "Nichols",
		"Herrera", "Medina", "Ryan", "Fernandez", "Weaver",
		"Daniels", "Stephens", "Gardner", "Payne", "Kelley",
		"Dunn", "Pierce", "Arnold", "Tran", "Spencer",
		"Peters", "Hawkins", "Grant", "Hansen", "Castro",
		"Hoffman", "Hart", "Elliott", "Cunningham",
		"Knight", "Bradley", "Carroll", "Hudson", "Duncan",
		"Armstrong", "Berry", "Andrews", "Johnston", "Ray",
		"Lane", "Riley", "Carpenter", "Perkins", "Aguilar",
		"Silva", "Richards", "Willis", "Matthews",
		"Chapman", "Lawrence", "Garza", "Vargas",
		"Watkins", "Wheeler", "Larson", "Carlson",
		"Harper", "George", "Greene", "Burke", "Guzman",
		"Morrison", "Munoz", "Jacobs", "O'Brien", "Lawson",
		"Franklin", "Lynch", "Bishop", "Carr", "Salazar",
		"Austin", "Mendez", "Gilbert", "Jensen",
		"Williamson", "Montgomery", "Harvey", "Oliver",
		"Howell", "Dean", "Hanson", "Weber", "Garrett",
		"Sims", "Burton", "Fuller", "Soto", "Mccoy",
		"Welch", "Chen", "Schultz", "Walters", "Reid",
		"Fields", "Walsh", "Little", "Fowler", "Bowman",
		"Davidson", "May", "Day", "Schneider", "Newman",
		"Brewer", "Lucas", "Holland", "Wong", "Banks",
		"Santos", "Curtis", "Pearson", "Delgado", "Valdez",
		"Pena", "Rios", "Douglas", "Sandoval", "Barrett",
		"Hopkins", "Keller", "Guerrero", "Stanley", "Bates",
		"Alvarado", "Beck", "Ortega", "Wade", "Estrada",
		"Contreras", "Barnett", "Caldwell", "Santiago",
		"Lambert", "Powers", "Chambers", "Nunez", "Craig",
		"Leonard", "Lowe", "Rhodes", "Byrd", "Gregory",
		"Shelton", "Frazier", "Becker", "Maldonado",
		"Fleming", "Vega", "Sutton", "Cohen", "Jennings",
		"Parks", "Mcdaniel", "Watts", "Barker", "Norris",
		"Vaughn", "Vazquez", "Holt", "Schwartz", "Steele",
		"Benson", "Neal", "Dominguez", "Horton", "Terry",
		"Wolfe", "Hale", "Lyons", "Graves", "Haynes",
		"Miles", "Park", "Warner", "Padilla", "Bush",
		"Thornton", "Mccarthy", "Mann", "Zimmerman",
		"Erickson", "Fletcher", "Mckinney", "Page",
		"Dawson", "Joseph", "Marquez", "Reeves", "Klein",
		"Espinoza", "Baldwin", "Moran", "Love", "Robbins",
		"Higgins", "Ball", "Cortez", "Le", "Griffith",
		"Bowen", "Sharp", "Cummings", "Ramsey", "Hardy",
		"Swanson", "Barber", "Acosta", "Luna", "Chandler",
		"Blair", "Daniel", "Cross", "Simon", "Dennis",
		"O'Connor", "Quinn", "Gross", "Navarro", "Moss",
		"Fitzgerald", "Doyle", "Mclaughlin", "Rojas",
		"Rodgers", "Stevenson", "Singh", "Yang", "Figueroa",
		"Harmon", "Newton", "Paul", "Manning", "Garner",
		"Mcgee", "Reese", "Francis", "Burgess", "Adkins",
		"Goodman", "Curry", "Brady", "Christensen", "Potter",
		"Walton", "Goodwin", "Mullins", "Molina", "Webster",
		"Fischer", "Campos", "Avila", "Sherman", "Todd",
		"Chang", "Blake", "Malone", "Wolf", "Hodges",
		"Juarez", "Gill", "Farmer", "Hines", "Gallagher",
		"Duran", "Hubbard", "Cannon", "Miranda", "Wang",
		"Saunders", "Tate", "Mack", "Hammond", "Carrillo",
		"Townsend", "Wise", "Ingram", "Barton", "Mejia",
		"Ayala", "Schroeder", "Hampton", "Rowe", "Parsons",
		"Frank", "Waters", "Strickland", "Osborne",
		"Maxwell", "Chan", "Deleon", "Norman", "Harrington",
		"Casey", "Patton", "Logan", "Bowers", "Mueller",
		"Glover", "Floyd", "Hartman", "Buchanan", "Cobb",
		"French", "Kramer", "Mccormick", "Clarke", "Tyler",
		"Gibbs", "Moody", "Conner", "Sparks", "Mcguire",
		"Leon", "Bauer", "Norton", "Pope", "Flynn",
		"Hogan", "Robles", "Salinas", "Yates", "Lindsey",
		"Lloyd", "Marsh", "Mcbride", "Owen", "Solis",
		"Pham", "Lang", "Pratt", "Lara", "Brock", "Ballard",
		"Trujillo", "Shaffer", "Drake", "Roman", "Aguirre",
		"Morton", "Stokes", "Lamb", "Pacheco", "Patrick",
		"Cochran", "Shepherd", "Cain", "Burnett", "Hess",
		"Li", "Cervantes", "Olsen", "Briggs", "Ochoa",
		"Cabrera", "Velasquez", "Montoya", "Roth", "Meyers",
		"Cardenas", "Fuentes", "Weiss", "Hoover", "Wilkins",
		"Nicholson", "Underwood", "Short", "Carson",
		"Morrow", "Colon", "Holloway", "Summers", "Bryan",
		"Petersen", "Mckenzie", "Serrano", "Wilcox",
		"Carey", "Clayton", "Poole", "Calderon", "Gallegos",
		"Greer", "Rivas", "Guerra", "Decker", "Collier",
		"Wall", "Whitaker", "Bass", "Flowers", "Davenport",
		"Conley", "Houston", "Huff", "Copeland", "Hood",
		"Monroe", "Massey", "Roberson", "Combs", "Franco",
		"Larsen", "Pittman", "Randall", "Skinner",
		"Wilkinson", "Kirby", "Cameron", "Bridges",
		"Anthony", "Richard", "Kirk", "Bruce", "Singleton",
		"Mathis", "Bradford", "Boone", "Abbott", "Charles",
		"Allison", "Sweeney", "Atkinson", "Horn",
		"Jefferson", "Rosales", "York", "Christian",
		"Phelps", "Farrell", "Castaneda", "Nash",
		"Dickerson", "Bond", "Wyatt", "Foley", "Chase",
		"Gates", "Vincent", "Mathews", "Hodge", "Garrison",
		"Trevino", "Villarreal", "Heath", "Dalton",
		"Valencia", "Callahan", "Hensley", "Atkins",
		"Huffman", "Roy", "Boyer", "Shields", "Lin",
		"Hancock", "Grimes", "Glenn", "Cline", "Delacruz",
		"Camacho", "Dillon", "Parrish", "O'Neill", "Melton",
		"Booth", "Kane", "Berg", "Harrell", "Pitts",
		"Savage", "Wiggins", "Brennan", "Salas", "Marks",
		"Russo", "Sawyer", "Baxter", "Golden", "Hutchinson",
		"Liu", "Walter", "Mcdowell", "Wiley", "Rich",
		"Humphrey", "Johns", "Koch", "Suarez", "Hobbs",
		"Beard", "Gilmore", "Ibarra", "Keith", "Macias",
		"Khan", "Andrade", "Ware", "Stephenson", "Henson",
		"Wilkerson", "Dyer", "Mcclure", "Blackwell",
		"Mercado", "Tanner", "Eaton", "Clay", "Barron",
		"Beasley", "O'Neal", "Preston", "Small", "Wu",
		"Zamora", "Macdonald", "Vance", "Snow", "Mcclain",
		"Stafford", "Orozco", "Barry", "English", "Shannon",
		"Kline", "Jacobson", "Woodard", "Huang", "Kemp",
		"Mosley", "Prince", "Merritt", "Hurst", "Villanueva",
		"Roach", "Nolan", "Lam", "Yoder", "Mccullough",
		"Lester", "Santana", "Valenzuela", "Winters",
		"Barrera", "Leach", "Orr", "Berger", "Mckee",
		"Strong", "Conway", "Stein", "Whitehead", "Bullock",
		"Escobar", "Knox", "Meadows", "Solomon", "Velez",
		"O'Donnell", "Kerr", "Stout", "Blankenship",
		"Browning", "Kent", "Lozano", "Bartlett", "Pruitt",
		"Buck", "Barr", "Gaines", "Durham", "Gentry",
		"Mcintyre", "Sloan", "Melendez", "Rocha", "Herman",
		"Sexton", "Moon", "Hendricks", "Rangel", "Stark",
		"Lowery", "Hardin", "Hull", "Sellers", "Ellison",
		"Calhoun", "Gillespie", "Mora", "Knapp", "Mccall",
		"Morse", "Dorsey", "Weeks", "Nielsen", "Livingston",
		"Leblanc", "Mclean", "Bradshaw", "Glass",
		"Middleton", "Buckley", "Schaefer", "Frost",
		"Howe", "House", "Mcintosh", "Ho", "Pennington",
		"Reilly", "Hebert", "Mcfarland", "Hickman", "Noble",
		"Spears", "Conrad", "Arias", "Galvan", "Velazquez",
		"Huynh", "Frederick", "Randolph", "Cantu",
		"Fitzpatrick", "Mahoney", "Peck", "Villa",
		"Michael", "Donovan", "Mcconnell", "Walls",
		"Boyle", "Mayer", "Zuniga", "Giles", "Pineda",
		"Pace", "Hurley", "Mays", "Mcmillan", "Crosby",
		"Ayers", "Case", "Bentley", "Shepard", "Everett",
		"Pugh", "David", "Mcmahon", "Dunlap", "Bender",
		"Hahn", "Harding", "Acevedo", "Raymond", "Blackburn",
		"Duffy", "Landry", "Dougherty", "Bautista", "Shah",
		"Potts", "Arroyo", "Valentine", "Meza", "Gould",
		"Vaughan", "Fry", "Rush", "Avery", "Herring",
		"Dodson", "Clements", "Sampson", "Tapia", "Bean",
		"Lynn", "Crane", "Farley", "Cisneros", "Benton",
		"Ashley", "Mckay", "Finley", "Best", "Blevins",
		"Friedman", "Moses", "Sosa", "Blanchard", "Huber",
		"Frye", "Krueger", "Bernard", "Rosario", "Rubio",
		"Mullen", "Benjamin", "Haley", "Chung", "Moyer",
		"Choi", "Horne", "Yu", "Woodward", "Ali",
		"Nixon", "Hayden", "Rivers", "Estes", "Mccarty",
		"Richmond", "Stuart", "Maynard", "Brandt",
		"O'Connell", "Hanna", "Sanford", "Sheppard",
		"Church", "Burch", "Levy", "Rasmussen", "Coffey",
		"Ponce", "Faulkner", "Donaldson", "Schmitt",
		"Novak", "Costa", "Montes", "Booker", "Cordova",
		"Waller", "Arellano", "Maddox", "Mata", "Bonilla",
		"Stanton", "Compton", "Kaufman", "Dudley",
		"Mcpherson", "Beltran", "Dickson", "Mccann",
		"Villegas", "Proctor", "Hester", "Cantrell",
		"Daugherty", "Cherry", "Bray", "Davila", "Rowland",
		"Levine", "Madden", "Spence", "Good", "Irwin",
		"Werner", "Krause", "Petty", "Whitney", "Baird",
		"Hooper", "Pollard", "Zavala", "Jarvis", "Holden",
		"Haas", "Hendrix", "Mcgrath", "Bird", "Lucero",
		"Terrell", "Riggs", "Joyce", "Mercer", "Rollins",
		"Galloway", "Duke", "Odom", "Andersen", "Downs",
		"Hatfield", "Benitez", "Archer", "Huerta", "Travis",
		"Mcneil", "Hinton", "Zhang", "Hays", "Mayo",
		"Fritz", "Branch", "Mooney", "Ewing", "Ritter",
		"Esparza", "Frey", "Braun", "Gay", "Riddle",
		"Haney", "Kaiser", "Holder", "Chaney", "Mcknight",
		"Gamble", "Vang", "Cooley", "Carney", "Cowan",
		"Forbes", "Ferrell", "Davies", "Barajas", "Shea",
		"Osborn", "Bright", "Cuevas", "Bolton", "Murillo",
		"Lutz", "Duarte", "Kidd", "Key", "Cooke"};
	private static String[] maleFirstNames = {
		"James", "John", "Robert", "Michael",
		"William", "David", "Richard", "Charles", "Joseph",
		"Thomas", "Christopher", "Daniel", "Paul", "Mark",
		"Donald", "George", "Kenneth", "Steven", "Edward",
		"Brian", "Ronald", "Anthony", "Kevin", "Jason",
		"Matthew", "Gary", "Timothy", "Jose", "Larry", "Jeffrey",
		"Frank", "Scott", "Eric", "Stephen", "Andrew", "Raymond",
		"Gregory", "Joshua", "Jerry", "Dennis", "Walter",
		"Patrick", "Peter", "Harold", "Douglas", "Henry", "Carl",
		"Arthur", "Ryan", "Roger", "Joe", "Juan", "Jack",
		"Albert", "Jonathan", "Justin", "Terry", "Gerald",
		"Keith", "Samuel", "Willie", "Ralph", "Lawrence",
		"Nicholas", "Roy", "Benjamin", "Bruce", "Brandon", "Adam",
		"Harry", "Fred", "Wayne", "Billy", "Steve", "Louis",
		"Jeremy", "Aaron", "Randy", "Howard", "Eugene",	"Carlos",
		"Russell", "Bobby", "Victor", "Martin", "Ernest",
		"Phillip", "Todd", "Jesse", "Craig", "Alan", "Shawn",
		"Clarence", "Sean", "Philip", "Chris", "Johnny", "Earl",
		"Jimmy", "Antonio", "Danny", "Bryan", "Tony", "Luis",
		"Mike", "Stanley", "Leonard", "Nathan", "Dale", "Manuel",
		"Rodney", "Curtis", "Norman", "Allen", "Marvin",
		"Vincent", "Glenn", "Jeffery", "Travis", "Jeff", "Chad",
		"Jacob", "Lee", "Melvin", "Alfred", "Kyle", "Francis",
		"Bradley", "Jesus", "Herbert", "Frederick", "Ray", "Joel",
		"Edwin", "Don", "Eddie", "Ricky", "Troy", "Randall",
		"Barry", "Alexander", "Bernard", "Mario", "Leroy",
		"Francisco", "Marcus", "Micheal", "Theodore", "Clifford",
		"Miguel", "Oscar", "Jay", "Jim", "Tom", "Calvin", "Alex",
		"Jon", "Ronnie", "Bill", "Lloyd", "Tommy", "Leon",
		"Derek", "Warren", "Darrell", "Jerome", "Floyd", "Leo",
		"Alvin", "Tim", "Wesley", "Gordon", "Dean", "Greg",
		"Jorge", "Dustin", "Pedro", "Derrick", "Dan", "Lewis",
		"Zachary", "Corey", "Herman", "Maurice", "Vernon",
		"Roberto", "Clyde", "Glen", "Hector", "Shane", "Ricardo",
		"Sam", "Rick", "Lester", "Brent", "Ramon", "Charlie",
		"Tyler", "Gilbert", "Gene", "Marc", "Reginald", "Ruben",
		"Brett", "Angel", "Nathaniel", "Rafael", "Leslie",
		"Edgar", "Milton", "Raul", "Ben", "Chester", "Cecil",
		"Duane", "Franklin", "Andre", "Elmer", "Brad", "Gabriel",
		"Ron", "Mitchell", "Roland", "Arnold", "Harvey", "Jared",
		"Adrian", "Karl", "Cory", "Claude", "Erik", "Darryl",
		"Jamie", "Neil", "Jessie", "Christian", "Javier",
		"Fernando", "Clinton", "Ted", "Mathew", "Tyrone",
		"Darren", "Lonnie", "Lance", "Cody", "Julio", "Kelly",
		"Kurt", "Allan", "Nelson", "Guy", "Clayton", "Hugh",
		"Max", "Dwayne", "Dwight", "Armando", "Felix", "Jimmie",
		"Everett", "Jordan", "Ian", "Wallace", "Ken", "Bob",
		"Jaime", "Casey", "Alfredo", "Alberto", "Dave", "Ivan",
		"Johnnie", "Sidney", "Byron", "Julian", "Isaac", "Morris",
		"Clifton", "Willard", "Daryl", "Ross", "Virgil", "Andy",
		"Marshall", "Salvador", "Perry", "Kirk", "Sergio",
		"Marion", "Tracy", "Seth", "Kent", "Terrance", "Rene",
		"Eduardo", "Terrence", "Enrique", "Freddie", "Wade"};
	private static String[] femaleFirstNames = {"Mary", "Patricia", "Linda",
		"Barbara", "Elizabeth", "Jennifer", "Maria", "Susan",
		"Margaret", "Dorothy", "Lisa", "Nancy", "Karen",
		"Betty", "Helen", "Sandra", "Donna", "Carol", "Ruth",
		"Sharon", "Michelle", "Laura", "Sarah", "Kimberly",
		"Deborah", "Jessica", "Shirley", "Cynthia", "Angela",
		"Melissa", "Brenda", "Amy", "Anna", "Rebecca",
		"Virginia", "Kathleen", "Pamela", "Martha", "Debra",
		"Amanda", "Stephanie", "Carolyn", "Christine", "Marie",
		"Janet", "Catherine", "Frances", "Ann", "Joyce", "Diane",
		"Alice", "Julie", "Heather", "Teresa", "Doris", "Gloria",
		"Evelyn", "Jean", "Cheryl", "Mildred", "Katherine",
		"Joan", "Ashley", "Judith", "Rose", "Janice", "Kelly",
		"Nicole", "Judy", "Christina", "Kathy", "Theresa",
		"Beverly", "Denise", "Tammy", "Irene", "Jane", "Lori",
		"Rachel", "Marilyn", "Andrea", "Kathryn", "Louise",
		"Sara", "Anne", "Jacqueline", "Wanda", "Bonnie", "Julia",
		"Ruby", "Lois", "Tina", "Phyllis", "Norma", "Paula",
		"Diana", "Annie", "Lillian", "Emily", "Robin", "Peggy",
		"Crystal", "Gladys", "Rita", "Dawn", "Connie", "Florence",
		"Tracy", "Edna", "Tiffany", "Carmen", "Rosa", "Cindy",
		"Grace", "Wendy", "Victoria", "Edith", "Kim", "Sherry",
		"Sylvia", "Josephine", "Thelma", "Shannon", "Sheila",
		"Ethel", "Ellen", "Elaine", "Marjorie", "Carrie",
		"Charlotte", "Monica", "Esther", "Pauline", "Emma",
		"Juanita", "Anita", "Rhonda", "Hazel", "Amber", "Eva",
		"Debbie", "April", "Leslie", "Clara", "Lucille", "Jamie",
		"Joanne", "Eleanor", "Valerie", "Danielle", "Megan",
		"Alicia", "Suzanne", "Michele", "Gail", "Bertha",
		"Darlene", "Veronica", "Jill", "Erin", "Geraldine",
		"Lauren", "Cathy", "Joann", "Lorraine", "Lynn", "Sally",
		"Regina", "Erica", "Beatrice", "Dolores", "Bernice",
		"Audrey", "Yvonne", "Annette", "June", "Samantha",
		"Marion", "Dana", "Stacy", "Ana", "Renee", "Ida",
		"Vivian", "Roberta", "Holly", "Brittany", "Melanie",
		"Loretta", "Yolanda", "Jeanette", "Laurie", "Katie",
		"Kristen", "Vanessa", "Alma", "Sue", "Elsie", "Beth",
		"Jeanne", "Vicki", "Carla", "Tara", "Rosemary", "Eileen",
		"Terri", "Gertrude", "Lucy", "Tonya", "Ella", "Stacey",
		"Wilma", "Gina", "Kristin", "Jessie", "Natalie", "Agnes",
		"Vera", "Willie", "Charlene", "Bessie", "Delores",
		"Melinda", "Pearl", "Arlene", "Maureen", "Colleen",
		"Allison", "Tamara", "Joy", "Georgia", "Constance",
		"Lillie", "Claudia", "Jackie", "Marcia", "Tanya",
		"Nellie", "Minnie", "Marlene", "Heidi", "Glenda",
		"Lydia", "Viola", "Courtney", "Marian", "Stella",
		"Caroline", "Dora", "Jo", "Vickie", "Mattie", "Terry",
		"Maxine", "Irma", "Mabel", "Marsha", "Myrtle", "Lena",
		"Christy", "Deanna", "Patsy", "Hilda", "Gwendolyn",
		"Jennie", "Nora", "Margie", "Nina", "Cassandra", "Leah",
		"Penny", "Kay", "Priscilla", "Naomi", "Carole", "Brandy",
		"Olga", "Billie", "Dianne", "Tracey", "Leona", "Jenny",
		"Felicia", "Sonia", "Miriam", "Velma", "Becky", "Bobbie",
		"Violet", "Kristina", "Toni", "Misty", "Mae", "Shelly",
		"Daisy", "Ramona", "Sherri", "Erika", "Katrina", "Claire",
		"Lindsey", "Lindsay", "Geneva", "Guadalupe", "Belinda",
		"Margarita", "Sheryl", "Cora", "Faye", "Ada", "Natasha",
		"Sabrina", "Isabel", "Marguerite", "Hattie", "Harriet",
		"Molly", "Cecilia", "Kristi", "Brandi", "Blanche",
		"Sandy", "Rosie", "Joanna", "Iris", "Eunice", "Angie",
		"Inez", "Lynda", "Madeline", "Amelia", "Alberta",
		"Genevieve", "Monique", "Jodi", "Janie", "Maggie",
		"Kayla", "Sonya", "Jan", "Lee", "Kristine", "Candace",
		"Fannie", "Maryann", "Opal", "Alison", "Yvette", "Melody",
		"Luz", "Susie", "Olivia", "Flora", "Shelley", "Kristy",
		"Mamie", "Lula", "Lola", "Verna", "Beulah", "Antoinette",
		"Candice", "Juana", "Jeannette", "Pam", "Kelli", "Hannah",
		"Whitney", "Bridget", "Karla", "Celia", "Latoya", "Patty",
		"Shelia", "Gayle", "Della", "Vicky", "Lynne", "Sheri",
		"Marianne", "Kara", "Jacquelyn", "Erma", "Blanca", "Myra",
		"Leticia", "Pat", "Krista", "Roxanne", "Angelica",
		"Johnnie", "Robyn", "Francis", "Adrienne", "Rosalie",
		"Alexandra", "Brooke", "Bethany", "Sadie", "Bernadette",
		"Traci", "Jody", "Kendra", "Jasmine", "Nichole",
		"Rachael", "Chelsea", "Mable", "Ernestine", "Muriel",
		"Marcella", "Elena", "Krystal", "Angelina", "Nadine",
		"Kari", "Estelle", "Dianna", "Paulette", "Lora", "Mona",
		"Doreen", "Rosemarie", "Angel", "Desiree", "Antonia",
		"Hope", "Ginger", "Janis", "Betsy", "Christie", "Freda",
		"Mercedes", "Meredith", "Lynette", "Teri", "Cristina",
		"Eula", "Leigh", "Meghan", "Sophia", "Eloise", "Rochelle",
		"Gretchen", "Cecelia", "Raquel", "Henrietta", "Alyssa",
		"Jana", "Kelley", "Gwen", "Kerry", "Jenna", "Tricia",
		"Laverne", "Olive", "Alexis", "Tasha", "Silvia", "Elvira",
		"Casey", "Delia", "Sophie", "Kate", "Patti", "Lorena",
		"Kellie", "Sonja", "Lila", "Lana", "Darla", "May",
		"Mindy", "Essie", "Mandy", "Lorene", "Elsa", "Josefina",
		"Jeannie", "Miranda", "Dixie", "Lucia", "Marta", "Faith",
		"Lela", "Johanna", "Shari", "Camille", "Tami", "Shawna",
		"Elisa", "Ebony", "Melba", "Ora", "Nettie", "Tabitha",
		"Ollie", "Jaime", "Winifred", "Kristie", "Marina",
		"Alisha", "Aimee", "Rena", "Myrna", "Marla", "Tammie",
		"Latasha", "Bonita", "Patrice", "Ronda", "Sherrie",
		"Addie", "Francine", "Deloris", "Stacie", "Adriana",
		"Cheri", "Shelby", "Abigail", "Celeste", "Jewel", "Cara",
		"Adele", "Rebekah", "Lucinda", "Dorthy", "Chris", "Effie",
		"Trina", "Reba", "Shawn", "Sallie", "Aurora", "Lenora",
		"Etta", "Lottie", "Kerri", "Trisha", "Nikki", "Estella",
		"Francisca", "Josie", "Tracie", "Marissa", "Karin",
		"Brittney", "Janelle", "Lourdes", "Laurel", "Helene",
		"Fern", "Elva", "Corinne", "Kelsey", "Ina", "Bettie",
		"Elisabeth", "Aida", "Caitlin", "Ingrid", "Iva",
		"Eugenia", "Christa", "Goldie", "Cassie", "Maude",
		"Jenifer", "Therese", "Frankie", "Dena", "Lorna",
		"Janette", "Latonya", "Candy", "Morgan", "Consuelo",
		"Tamika", "Rosetta", "Debora", "Cherie", "Polly", "Dina",
		"Jewell", "Fay", "Jillian", "Dorothea", "Nell", "Trudy",
		"Esperanza", "Patrica", "Kimberley", "Shanna", "Helena",
		"Carolina", "Cleo", "Stefanie", "Rosario", "Ola",
		"Janine", "Mollie", "Lupe", "Alisa", "Lou", "Maribel",
		"Susanne", "Bette", "Susana", "Elise", "Cecile",
		"Isabelle", "Lesley", "Jocelyn", "Paige", "Joni",
		"Rachelle", "Leola", "Daphne", "Alta", "Ester", "Petra",
		"Graciela", "Imogene", "Jolene", "Keisha", "Lacey",
		"Glenna", "Gabriela", "Keri", "Ursula", "Lizzie",
		"Kirsten", "Shana", "Adeline", "Mayra", "Jayne",
		"Jaclyn", "Gracie", "Sondra", "Carmela", "Marisa",
		"Rosalind", "Charity", "Tonia", "Beatriz", "Marisol",
		"Clarice", "Jeanine", "Sheena", "Angeline", "Frieda",
		"Lily", "Robbie", "Shauna", "Millie", "Claudette",
		"Cathleen", "Angelia", "Gabrielle", "Autumn", "Katharine",
		"Summer", "Jodie", "Staci", "Lea", "Christi", "Jimmie",
		"Justine", "Elma", "Luella", "Margret", "Dominique",
		"Socorro", "Rene", "Martina", "Margo", "Mavis", "Callie",
		"Bobbi", "Maritza", "Lucile", "Leanne", "Jeannine",
		"Deana", "Aileen", "Lorie", "Ladonna", "Willa", "Manuela",
		"Gale", "Selma", "Dolly", "Sybil", "Abby", "Lara", "Dale",
		"Ivy", "Dee", "Winnie", "Marcy", "Luisa", "Jeri",
		"Magdalena", "Ofelia", "Meagan", "Audra", "Matilda",
		"Leila", "Cornelia", "Bianca", "Simone", "Bettye",
		"Randi", "Virgie", "Latisha", "Barbra", "Georgina",			
		"Eliza", "Leann", "Bridgette", "Rhoda", "Haley", "Adela",
		"Nola", "Bernadine", "Flossie", "Ila", "Greta", "Ruthie",
		"Nelda", "Minerva", "Lilly", "Terrie", "Letha", "Hilary",
		"Estela", "Valarie", "Brianna", "Rosalyn", "Earline",
		"Catalina", "Ava", "Mia", "Clarissa", "Lidia", "Corrine",
		"Alexandria", "Concepcion", "Tia", "Sharron", "Rae",
		"Dona", "Ericka", "Jami", "Elnora", "Chandra", "Lenore",
		"Neva", "Marylou", "Melisa", "Tabatha", "Serena", "Avis",
		"Allie", "Sofia", "Jeanie", "Odessa", "Nannie",
		"Harriett", "Loraine", "Penelope", "Milagros", "Emilia",
		"Benita", "Allyson", "Ashlee", "Tania", "Tommie",
		"Esmeralda", "Karina", "Eve", "Pearlie", "Zelma",
		"Malinda", "Noreen", "Tameka", "Saundra", "Hillary",
		"Amie", "Althea", "Rosalinda", "Jordan", "Lilia",
		"Alana", "Gay", "Clare", "Alejandra", "Elinor", "Michael",
		"Lorrie", "Jerri", "Darcy", "Earnestine", "Carmella",
		"Taylor", "Noemi", "Marcie", "Liza", "Annabelle",
		"Louisa", "Earlene", "Mallory", "Carlene", "Nita",
		"Selena", "Tanisha", "Katy", "Julianne", "John",
		"Lakisha", "Edwina", "Maricela", "Margery", "Kenya",
		"Dollie", "Roxie", "Roslyn", "Kathrine", "Nanette",
		"Charmaine", "Lavonne", "Ilene", "Kris", "Tammi",
		"Suzette", "Corine", "Kaye", "Jerry", "Merle", "Chrystal",
		"Lina", "Deanne", "Lilian", "Juliana", "Aline", "Luann",
		"Kasey", "Maryanne", "Evangeline", "Colette", "Melva",
		"Lawanda", "Yesenia", "Nadia", "Madge", "Kathie", "Eddie",
		"Ophelia", "Valeria", "Nona", "Mitzi", "Mari",
		"Georgette", "Claudine", "Fran", "Alissa", "Roseann",
		"Lakeisha", "Susanna", "Reva", "Deidre", "Chastity",
		"Sheree", "Carly", "James", "Elvia", "Alyce", "Deirdre",
		"Gena", "Briana", "Araceli", "Katelyn", "Rosanne",
		"Wendi", "Tessa", "Berta", "Marva", "Imelda", "Marietta",
		"Marci", "Leonor", "Arline", "Sasha", "Madelyn", "Janna",
		"Juliette", "Deena", "Aurelia", "Josefa", "Augusta",
		"Liliana", "Young", "Christian", "Lessie", "Amalia",
		"Savannah", "Anastasia", "Vilma", "Natalia", "Rosella",
		"Lynnette", "Corina", "Alfreda", "Leanna", "Carey",
		"Amparo", "Coleen", "Tamra", "Aisha", "Wilda", "Karyn",
		"Cherry", "Queen", "Maura", "Mai", "Evangelina",
		"Rosanna", "Hallie", "Erna", "Enid", "Mariana", "Lacy",
		"Juliet", "Jacklyn", "Freida", "Madeleine", "Mara",
		"Hester", "Cathryn", "Lelia", "Casandra", "Bridgett",
		"Angelita", "Jannie", "Dionne", "Annmarie", "Katina",
		"Beryl", "Phoebe", "Millicent", "Katheryn", "Diann",
		"Carissa", "Maryellen", "Liz", "Lauri", "Helga", "Gilda",
		"Adrian", "Rhea", "Marquita", "Hollie", "Tisha", "Tamera",
		"Angelique", "Francesca", "Britney", "Kaitlin", "Lolita",
		"Florine", "Rowena", "Reyna", "Twila", "Fanny", "Janell",
		"Ines", "Concetta", "Bertie", "Alba", "Brigitte",
		"Alyson", "Vonda", "Pansy", "Elba", "Noelle", "Letitia",
		"Kitty", "Deann", "Brandie", "Louella", "Leta", "Felecia",
		"Sharlene", "Lesa", "Beverley", "Robert", "Isabella",
		"Herminia", "Terra", "Celina"};
	// mixture of American and English road names from:
	// http://funky-facts.blogspot.com/2009/03/most-common-street-names-in-uk.html
	// http://everything2.com/title/most+common+street+names+in+the+U.S.
	private static String[] roadNames = {"High Street",
		"Station Road", "Main Street", "Park Road", "Church Road",
		"Church Street", "London Road", "Victoria Road", "Green Lane",
		"Manor Road", "Church Lane", "Park Avenue", "The Avenue",
		"The Crescent", "Queens Road", "New Road", "Grange Road",
		"Kings Road", "Kingsway", "Windsor Road", "Highfield Road",
		"Mill Lane", "Alexander Road", "York Road", "St. John's Road",
		"Main Road", "Broadway", "King Street", "The Green",
		"Springfield Road", "George Street", "Park Lane",
		"Victoria Street", "Albert Road", "Queensway", "New Street",
		"Queen Street", "West Street", "North Street",
		"Manchester Road", "The Grove", "Richmond Road", "Grove Road",
		"South Street", "School Lane", "The Drive", "North Road",
		"Stanley Road", "Chester Road", "Mill Road", "Park Street",
		"Washington Street", "Maple Street", "Oak Street",
		"Lincoln Street", "Walnut Street", "Elm Street",
		"Jefferson Street", "Highland Street", "Madison Street",
		"Pine Street", "Cedar Street", "Sunset Street",
		"Jackson Street", "Franklin Street", "Willow Street",
		"3rd Street", "Wilson Street", "2nd Street", "Laurel Street",
		"5th Street", "Chestnut Street", "4th Street", "Adams Street",
		"Virginia Street", "Linden Street", "Woodland Street",
		"Cherry Street", "Rose Street", "1st Street"};
	// List of town names in New York from
	// http://uscitynameslist.com/BBB New York.htm
	private static String[] townNames = {"Adelanto, CA", "Agoura Hills, CA", 
		"Alameda, CA", "Albany, CA", "Alhambra, CA", "Aliso Viejo, CA", 
		"Alturas, CA", "Amador City, CA", "American Canyon, CA", "Anaheim, CA",
		"Anderson, CA", "Angels Camp, CA", "Antioch, CA", "Apple Valley, CA", 
		"Arcadia, CA", "Arcata, CA", "Arroyo Grande, CA", "Artesia, CA", 
		"Arvin, CA", "Atascadero, CA", "Atherton, CA", "Atwater, CA", 
		"Auburn, CA", "Avalon, CA", "Avenal, CA", "Azusa, CA", 
		"Bakersfield, CA", "Baldwin Park, CA", "Banning, CA", "Barstow, CA", 
		"Beaumont, CA", "Bell, CA", "Bell Gardens, CA", "Bellflower, CA", 
		"Belmont, CA", "Belvedere, CA", "Benicia, CA", "Berkeley, CA", 
		"Beverly Hills, CA", "Big Bear Lake, CA", "Biggs, CA", "Bishop, CA", 
		"Blue Lake, CA", "Blythe, CA", "Bradbury, CA", "Brawley, CA", "Brea, CA", 
		"Brentwood, CA", "Brisbane, CA", "Buellton, CA", "Buena Park, CA", 
		"Burbank, CA", "Burlingame, CA", "Calabasas, CA", "Calexico, CA",
		"California City, CA", "Calimesa, CA", "Calipatria, CA", "Calistoga, CA", 
		"Camarillo, CA", "Campbell, CA", "Canyon Lake, CA", "Capitola, CA", 
		"Carlsbad, CA", "Carmel-by-the-Sea, CA", "Carpinteria, CA", "Carson, CA", 
		"Cathedral City, CA", "Ceres, CA", "Cerritos, CA", "Chico, CA", 
		"Chino, CA", "Chino Hills, CA", "Chowchilla, CA", "Chula Vista, CA", 
		"Citrus Heights, CA", "Claremont, CA", "Clayton, CA", "Clearlake, CA", 
		"Cloverdale, CA", "Clovis, CA", "Coachella, CA", "Coalinga, CA", 
		"Colfax, CA", "Colma, CA", "Colton, CA", "Colusa, CA", "Commerce, CA", 
		"Compton, CA", "Concord, CA", "Corcoran, CA", "Corning, CA", "Corona, CA", 
		"Coronado, CA", "Corte Madera, CA", "Costa Mesa, CA", "Cotati, CA", 
		"Covina, CA", "Crescent City, CA", "Cudahy, CA", "Culver City, CA", 
		"Cupertino, CA", "Cypress, CA", "Daly City, CA", "Dana Point, CA", 
		"Danville, CA", "Davis, CA", "Del Mar, CA", "Del Rey Oaks, CA", 
		"Delano, CA", "Desert Hot Springs, CA", "Diamond Bar, CA", "Dinuba, CA", 
		"Dixon, CA", "Dorris, CA", "Dos Palos, CA", "Downey, CA", "Duarte, CA", 
		"Dublin, CA", "Dunsmuir, CA", "East Palo Alto, CA", "Eastvale, CA", 
		"El Cajon, CA", "El Centro, CA", "El Cerrito, CA", "El Monte, CA", "El Segundo, CA", 
		"Elk Grove, CA", "Emeryville, CA", "Encinitas, CA", "Escalon, CA", "Escondido, CA", 
		"Etna, CA", "Eureka, CA", "Exeter, CA", "Fairfax, CA", "Fairfield, CA", 
		"Farmersville, CA", "Ferndale, CA", "Fillmore, CA", "Firebaugh, CA", "Folsom, CA", 
		"Fontana, CA", "Fort Bragg, CA", "Fort Jones, CA", "Fortuna, CA", "Foster City, CA", 
		"Fountain Valley, CA", "Fowler, CA", "Fremont, CA", "Fresno, CA", "Fullerton, CA", 
		"Galt, CA", "Garden Grove, CA", "Gardena, CA", "Gilroy, CA", "Glendale, CA", 
		"Glendora, CA", "Goleta, CA", "Gonzales, CA", "Grand Terrace, CA", "Grass Valley, CA", 
		"Greenfield, CA", "Gridley, CA", "Grover Beach, CA", "Guadalupe, CA", "Gustine, CA", 
		"Half Moon Bay, CA", "Hanford, CA", "Hawaiian Gardens, CA", "Hawthorne, CA", 
		"Hayward, CA", "Healdsburg, CA", "Hemet, CA", "Hercules, CA", "Hermosa Beach, CA", 
		"Hesperia, CA", "Hidden Hills, CA", "Highland, CA", "Hillsborough, CA", "Hollister, CA", 
		"Holtville, CA", "Hughson, CA", "Huntington Beach, CA", "Huntington Park, CA",
		"Huron, CA", "Imperial, CA", "Imperial Beach, CA", "Indian Wells, CA", "Indio, CA", 
		"Industry, CA", "Inglewood, CA", "Ione, CA", "Irvine, CA", "Irwindale, CA", "Isleton, CA", 
		"Jackson, CA", "Jurupa Valley, CA", "Kerman, CA", "King City, CA", "Kingsburg, CA", 
		"La Ca¤ada Flintridge, CA", "La Habra, CA", "La Habra Heights, CA", "La Mesa, CA",
		"La Mirada, CA", "La Palma, CA", "La Puente, CA", "La Quinta, CA", "La Verne, CA", 
		"Lafayette, CA", "Laguna Beach, CA", "Laguna Hills, CA", "Laguna Niguel, CA", 
		"Laguna Woods, CA", "Lake Elsinore, CA", "Lake Forest, CA", "Lakeport, CA", 
		"Lakewood, CA", "Lancaster, CA", "Larkspur, CA", "Lathrop, CA", "Lawndale, CA", 
		"Lemon Grove, CA", "Lemoore, CA", "Lincoln, CA", "Lindsay, CA", "Live Oak, CA",
		"Livermore, CA", "Livingston, CA", "Lodi, CA", "Loma Linda, CA", "Lomita, CA", 
		"Lompoc, CA", "Long Beach, CA", "Loomis, CA", "Los Alamitos, CA", "Los Altos, CA", 
		"Los Altos Hills, CA", "Los Angeles, CA", "Los Banos, CA", "Los Gatos, CA", "Loyalton, CA", 
		"Lynwood, CA", "Madera, CA", "Malibu, CA", "Mammoth Lakes, CA", 
		"Manhattan Beach, CA", "ManteCA", "CA", "Maricopa, CA", "Marina, CA", "Martinez, CA",
		"Marysville, CA", "Maywood, CA", "McFarland, CA", "Mendota, CA", "Menifee, CA", 
		"Menlo Park, CA", "Merced, CA", "Mill Valley, CA", "Millbrae, CA", "Milpitas, CA", 
		"Mission Viejo, CA", "Modesto, CA", "Monrovia, CA", "Montague, CA", "Montclair, CA",
		"Monte Sereno, CA", "Montebello, CA", "Monterey, CA", "Monterey Park, CA", 
		"Moorpark, CA", "Moraga, CA", "Moreno Valley, CA", "Morgan Hill, CA", "Morro Bay, CA",
		"Mount Shasta, CA", "Mountain View, CA", "Murrieta, CA", "Napa, CA", "National City, CA",
		"Needles, CA", "Nevada City, CA", "Newark, CA", "Newman, CA", "Newport Beach, CA", 
		"Norco, CA", "Norwalk, CA", "Novato, CA", "Oakdale, CA", "Oakland, CA", "Oakley, CA", 
		"Oceanside, CA", "Ojai, CA", "Ontario, CA", "Orange, CA", "Orange Cove, CA", "Orinda, CA", 
		"Orland, CA", "Oroville, CA", "Oxnard, CA", "Pacific Grove, CA", "Pacifica. CA", 
		"Palm Desert, CA", "Palm Springs, CA", "Palmdale, CA", "Palo Alto, CA", 
		"Palos Verdes Estates, CA", "Paradise, CA", "Paramount, CA", "Parlier, CA", "Pasadena, CA",
		"Paso Robles, CA", "Patterson, CA", "Perris, CA", "Petaluma, CA", "Pico Rivera, CA", 
		"Piedmont, CA", "Pinole, CA", "Pismo Beach, CA", "Pittsburg, CA", "Placentia, CA", 
		"Placerville, CA", "Pleasant Hill, CA", "Pleasanton, CA", "Plymouth, CA", "Point Arena, CA", 
		"Pomona, CA", "Port Hueneme, CA", "Porterville, CA", "Portola, CA", "Portola Valley, CA", 
		"Poway, CA", "Rancho Cordova, CA", "Rancho Cucamonga, CA", "Rancho Mirage, CA", 
		"Rancho Palos Verdes, CA", "Rancho Santa Margarita, CA", "Red Bluff, CA", "Redding, CA", 
		"Redlands, CA", "Redondo Beach, CA", "Redwood City, CA", "Reedley, CA", "Rialto, CA", 
		"Richmond, CA", "Ridgecrest, CA", "Rio Dell, CA", "Rio Vista, CA", "Ripon, CA", 
		"Riverbank, CA", "Riverside, CA", "Rocklin, CA", "Rohnert Park, CA", "Rolling Hills, CA", 
		"Rolling Hills Estates, CA", "Rosemead, CA", "Roseville, CA", "Ross, CA", "Sacramento, CA", 
		"Salinas, CA", "San Anselmo, CA", "San Bernardino, CA", "San Bruno, CA", "San Carlos, CA",
		"San Clemente, CA", "San Diego, CA", "San Dimas, CA", "San Fernando, CA", 
		"San Francisco, CA", "San Gabriel, CA", "San Jacinto, CA", "San Joaquin, CA", 
		"San Jose, CA", "San Juan Bautista, CA", "San Juan Capistrano, CA", "San Leandro, CA", 
		"San Luis Obispo, CA", "San Marcos, CA", "San Marino, CA", "San Mateo, CA", 
		"San Pablo, CA", "San Rafael, CA", "San Ramon, CA", "Sand City, CA", "Sanger, CA", 
		"Santa Ana, CA", "Santa Barbara, CA", "Santa Clara, CA", "Santa Clarita, CA", 
		"Santa Cruz, CA", "Santa Fe Springs, CA", "Santa Maria, CA", "Santa MoniCA", "CA", 
		"Santa Paula, CA", "Santa Rosa, CA", "Santee, CA", "Saratoga, CA", "Sausalito, CA", 
		"Scotts Valley, CA", "Seal Beach, CA", "Seaside, CA", "Sebastopol Selma, CA", "Shafter, CA", 
		"Shasta Lake, CA", "Sierra Madre, CA", "Signal Hill, CA", "Simi Valley, CA", 
		"Solana Beach, CA", "Soledad, CA", "Solvang, CA", "Sonoma, CA", "Sonora, CA", 
		"South El Monte, CA", "South Gate, CA", "South Lake Tahoe, CA", "South Pasadena, CA", 
		"South San Francisco, CA", "St. Helena, CA", "Stanton, CA", "Stockton, CA", 
		"Suisun City, CA", "Sunnyvale, CA", "Susanville, CA", "Sutter Creek, CA", "Taft, CA", 
		"Tehachapi, CA", "Tehama, CA", "Temecula, CA", "Temple City, CA", "Thousand Oaks, CA", 
		"Tiburon, CA", "Torrance, CA", "Tracy, CA", "Trinidad, CA", "Truckee, CA", "Tulare, CA", 
		"Tulelake, CA", "Turlock, CA", "Tustin, CA", "Twentynine Palms, CA", "Ukiah, CA", 
		"Union City, CA", "Upland, CA", "Vacaville, CA", "Vallejo, CA", "Ventura, CA", 
		"Vernon, CA", "Victorville, CA", "Villa Park, CA", "Visalia, CA", "Vista, CA", "Walnut, CA", 
		"Walnut Creek, CA", "Wasco, CA", "Waterford, CA", "Watsonville, CA", "Weed, CA", 
		"West Covina, CA", "West Hollywood, CA", "West Sacramento, CA", "Westlake Village, CA", 
		"Westminster, CA", "Westmorland, CA", "Wheatland, CA", "Whittier, CA", "Wildomar, CA",
		"Williams, CA", "Willits, CA", "Willows, CA", "Windsor, CA", "Winters, CA", 
		"Woodlake, CA", "Woodland, CA", "Woodside, CA", "Yorba Linda, CA", 
		"Yountville, CA", "Yreka, CA", "Yuba City, CA", "Yucaipa, CA", 
		"Yucca Valley, CA", "Alviso, CA", "Annandale, CA", "Bairdstown, CA", 
		"Bayshore City, CA", "Brooklyn, CA", "Cabazon, CA", "Eagle Rock, CA", "Hyde Park, CA", 
		"Highland Park, CA", "Hollywood, CA", "North Sacramento, CA", "San Pedro, CA", 
		"Sawtelle, CA", "Venice, CA", "Watts, CA", "Willow Glen, CA", "Wilmington, CA",

		"Adams, NY", "Afton, NY", "Akron, NY", "Albany, NY",
		"Albertson, NY", "Albion, NY", "Alden, NY", "Alexandria Bay, NY", "Alfred, NY",
		"Allegany, NY", "Altamont, NY", "Amagansett, NY", "Amherst, NY",
		"Amityville, NY", "Amsterdam, NY", "Ancram, NY", "Andes, NY", "Andover, NY",
		"Angelica, NY", "Angola, NY", "Apalachin, NY", "Appleton, NY", "Aquebogue, NY",
		"Arcade, NY", "Ardsley, NY", "Arkport, NY", "Arkville, NY", "Armonk, NY",
		"Ashville, NY", "Astoria, NY", "Atlantic Beach, NY", "Attica, NY",
		"Au Sable Forks, NY", "Auburn, NY", "Averill Park, NY", "Avon, NY",
		"Babylon, NY", "Bainbridge, NY", "Baldwin, NY", "Baldwinsville, NY",
		"Ballston Lake, NY", "Ballston Spa, NY", "Batavia, NY", "Bath, NY",
		"Bay Shore, NY", "Bayport, NY", "Bayside, NY", "Bayville, NY", "Beacon, NY",
		"Bearsville, NY", "Bedford, NY", "Bedford Hills, NY", "Bellerose, NY",
		"Bellmore, NY", "Bellport, NY", "Belmont, NY", "Bemus Point, NY", "Bergen, NY",
		"Berlin, NY", "Bethpage, NY", "Big Flats, NY", "Billings, NY", "Binghamton, NY",
		"Blauvelt, NY", "Bloomfield, NY", "Bloomingburg, NY", "Bloomville, NY",
		"Bohemia, NY", "Bolivar, NY", "Bolton Landing, NY", "Boonville, NY",
		"Boston, NY", "Bowling Green, NY", "Brasher Falls, NY", "Brentwood, NY",
		"Brewerton, NY", "Brewster, NY", "Briarcliff Manor, NY",
		"Bridgehampton, NY", "Brightwaters, NY", "Broadalbin, NY", "Brockport, NY",
		"Brocton, NY", "Bronx, NY", "Bronxville, NY", "Brooklyn, NY", "Buchanan, NY",
		"Buffalo, NY", "Burnt Hills, NY", "Cairo, NY", "Caledonia, NY",
		"Callicoon, NY", "Calverton, NY", "Cambria Heights, NY", "Cambridge, NY",
		"Camden, NY", "Camillus, NY", "Campbell Hall, NY", "Canaan, NY",
		"Canajoharie, NY", "Canal Street, NY", "Canandaigua, NY", "Canastota, NY",
		"Candor, NY", "Canisteo, NY", "Canton, NY", "Carle Place, NY", "Carmel, NY",
		"Caroga Lake, NY", "Carthage, NY", "Castleton On Hudson, NY", "Cato, NY",
		"Catskill, NY", "Cazenovia, NY", "Cedarhurst, NY", "Center Moriches, NY",
		"Centereach, NY", "Centerport, NY", "Central Islip, NY",
		"Central Square, NY", "Central Valley, NY", "Chappaqua, NY", "Chatham, NY",
		"Cheektowaga, NY", "Chenango Bridge, NY", "Cherry Valley, NY",
		"Chester, NY", "Chestertown, NY", "Chittenango, NY", "Churchville, NY",
		"Cicero, NY", "Clarence, NY", "Clarksville, NY", "Claverack, NY",
		"Clayton, NY", "Clifton Park, NY", "Clifton Springs, NY", "Climax, NY",
		"Clinton, NY", "Clinton Corners, NY", "Clyde, NY", "Clymer, NY",
		"Cobleskill, NY", "Coeymans, NY", "Cohoes, NY", "Cold Spring, NY",
		"Cold Spring Harbor, NY", "College Point, NY", "Collins, NY",
		"Commack, NY", "Congers, NY", "Cooperstown, NY", "Copake, NY", "Copiague, NY",
		"Coram, NY", "Corfu, NY", "Corinth, NY", "Corning, NY", "Cornwall, NY",
		"Cornwall On Hudson, NY", "Corona, NY", "Cortland, NY", "Cortlandt, NY",
		"anor, NY", "Coxsackie, NY", "Cross River, NY", "Croton On Hudson, NY",
		"Cuba, NY", "Cutchogue, NY", "Dansville, NY", "Deansboro, NY", "Deer Park, NY",
		"Delanson, NY", "Delevan, NY", "Delhi, NY", "Delmar, NY", "Depew, NY",
		"Deposit, NY", "Derby, NY", "Dexter, NY", "Dix Hills, NY", "Dobbs Ferry, NY",
		"Dolgeville, NY", "Douglaston, NY", "Dover Plains, NY", "Dryden, NY",
		"Duanesburg, NY", "Dundee, NY", "Dunkirk, NY", "Earlville, NY",
		"East Amherst, NY", "East Aurora, NY", "East Bloomfield, NY",
		"East Elmhurst, NY", "East Greenbush, NY", "East Hampton, NY",
		"East Islip, NY", "East Meadow, NY", "East Moriches, NY",
		"East Northport, NY", "East Norwich, NY", "East Quogue, NY",
		"East Rochester, NY", "East Rockaway, NY", "East Setauket, NY",
		"East Syracuse, NY", "East Williston, NY", "Eastchester, NY", "Eden, NY",
		"Edmeston, NY", "Elbridge, NY", "Eldred, NY", "Elizabethtown, NY",
		"Ellenville, NY", "Ellicottville, NY", "Elma, NY", "Elmhurst, NY",
		"Elmira, NY", "Elmont, NY", "Elmsford, NY", "Endicott, NY", "Fair Haven, NY",
		"Fairport, NY", "Falconer, NY", "Far Rockaway, NY", "Farmingdale, NY",
		"Farmington, NY", "Farmingville, NY", "Fayetteville, NY", "Ferndale, NY",
		"Fillmore, NY", "Findley Lake, NY", "Fishers, NY", "Fishkill, NY",
		"Floral, NY", " Park, NY", "Florida, NY", "Flushing, NY", "Fly Creek, NY",
		"Fonda, NY", "Forest Hills, NY", "Fort Covington, NY", "Fort Edward, NY",
		"Fort Plain, NY", "Franklin Square, NY", "Franklinville, NY",
		"Fredonia, NY", "Freeport, NY", "Freeville, NY", "Fresh Meadows, NY",
		"Fulton, NY", "Fultonham, NY", "Fultonville, NY", "Galway, NY",
		"Gansevoort, NY", "Garden City, NY", "Garnerville, NY", "Garrison, NY",
		"Geneseo, NY", "Geneva, NY", "Germantown, NY", "Getzville, NY", "Ghent, NY",
		"Gilbertsville, NY", "Glasco, NY", "Glen Cove, NY", "Glen Falls, NY",
		"Glen Head, NY", "Glen Oaks, NY", "Glendale, NY", "Glenmont, NY",
		"Glens Falls, NY", "Glenville, NY", "Gloversville, NY",
		"Goldens Bridge, NY", "Goshen, NY", "Gouverneur, NY", "Gowanda, NY",
		"Grahamsville, NY", "Grand Island, NY", "Granville, NY", "Great Neck, NY",
		"Greene, NY", "Greenlawn, NY", "Greenport, NY", "Greenvale, NY",
		"Greenville, NY", "Greenwich, NY", "Greenwood, NY", "Greenwood Lake, NY",
		"Groton, NY", "Guilderland, NY", "Hague, NY", "Halesite, NY", "Hamburg, NY",
		"Hamilton, NY", "Hamlin, NY", "Hammondsport, NY", "Hampton Bays, NY",
		"Hancock, NY", "Harriman, NY", "Harrison, NY", "Hartsdale, NY", "Hastings, NY",
		"Hastings On Hudson, NY", "Hauppauge, NY", "Haverstraw, NY",
		"Hawthorne, NY", "Hempstead, NY", "Henrietta, NY", "Herkimer, NY",
		"Hewlett, NY", "Hicksville, NY", "Highland, NY", "Highland Falls, NY",
		"Highland Mills, NY", "Hillsdale, NY", "Hilton, NY", "Hogansburg, NY",
		"Holbrook, NY", "Holland, NY", "Holland Patent, NY", "Holley, NY", "Hollis, NY",
		"oltsville, NY", "Homer, NY", "Honeoye, NY", "Honeoye Falls, NY",
		"Hoosick Falls, NY", "Hopewell Junction, NY", "Hornell, NY",
		"Horseheads, NY", "Houghton, NY", "Howard Beach, NY", "Howells, NY",
		"Hudson, NY", "Hudson Falls, NY", "Hunter, NY", "Huntington, NY",
		"Huntington Station, NY", "Hurley, NY", "Hyde Park, NY", "Ilion, NY",
		"Inlet, NY", "Interlaken, NY", "Inwood, NY", "Irvington, NY",
		"Island Park, NY", "Islandia, NY", "Islip, NY", "Islip Terrace, NY",
		"Ithaca, NY", "Jackson Heights, NY", "Jamaica, NY", "Jamesport, NY",
		"Jamestown, NY", "Jeffersonville, NY", "Jericho, NY", "Johnson City, NY",
		"Johnstown, NY", "Jordan, NY", "atonah, NY", "Keeseville, NY", "Kenmore, NY",
		"Kew Gardens, NY", "Kinderhook, NY", "King Ferry, NY", "Kings Park, NY",
		"Kingston, NY", "La Fayette, NY", "Lagrangeville, NY", "Lake George, NY",
		"Lake Grove, NY", "Lake Hill, NY", "Lake Luzerne, NY",
		"Lake Peekskill, NY", "Lake Placid, NY", "Lake Pleasant, NY",
		"Lakeville, NY", "Lakewood, NY", "Lancaster, NY", "Larchmont, NY",
		"Latham, NY", "Laurelton, NY", "Lawrence, NY", "Le Roy, NY", "Levittown, NY",
		"Lewiston, NY", "Liberty, NY", "Lima, NY", "Lindenhurst, NY",
		"Little Falls, NY", "Little Neck, NY", "Little Valley, NY",
		"Liverpool, NY", "Livingston Manor, NY", "Livonia, NY", "Lockport, NY",
		"Locust Valley, NY", "Lodi, NY", "Long Beach, NY", "Long Is City, NY",
		"Long Island City, NY", "Lowville, NY", "Lynbrook, NY", "Lyndonville, NY",
		"Lyons, NY", "Macedon, NY", "Mahopac, NY", "Malone, NY", "Malverne, NY",
		"Mamaroneck, NY", "Manhasset, NY", "Manhattan, NY", "Manlius, NY",
		"Marathon, NY", "Marcellus, NY", "Marcy, NY", "Margaretville, NY",
		"Marion, NY", "Marlboro, NY", "Maspeth, NY", "Massapequa, NY",
		"Massapequa Park, NY", "Massena, NY", "Mastic, NY", "Mastic Beach, NY",
		"Mattituck, NY", "Mayville, NY", "Mechanicville, NY", "Medford, NY",
		"Medina, NY", "Melville, NY", "Menands, NY", "Mendon, NY", "Merrick, NY",
		"Mexico, NY", "Middle Granville, NY", "Middle Island, NY",
		"Middle Village, NY", "Middleburgh, NY", "Middleport, NY",
		"Middletown, NY", "Millbrook, NY", "Miller Place, NY", "Millerton, NY",
		"Millwood, NY", "Milton, NY", "Mineola, NY", "Mohegan Lake, NY", "Monroe, NY",
		"Monsey, NY", "Montauk, NY", "Montgomery, NY", "Monticello, NY",
		"Montour Falls, NY", "Montrose, NY", "Moravia, NY", "Morris, NY",
		"Morristown, NY", "Morrisville, NY", "Mount Kisco, NY", "Mount Morris, NY",
		"Mount Sinai, NY", "Mount Vernon, NY", "Nanuet, NY", "Naples, NY",
		"Nassau, NY", "Nesconset, NY", "New Berlin, NY", "New City, NY",
		"New Hampton, NY", "New Hartford, NY", "New Hyde Park, NY",
		"New Paltz, NY", "New Rochelle, NY", "New Windsor, NY", "New York, NY",
		"New York Mills, NY", "Newark, NY", "Newburgh, NY", "Newport, NY",
		"Newyork, NY", "Niagara Falls, NY", "Niskayuna, NY", "North Babylon, NY",
		"North Baldwin, NY", "North Bellmore, NY", "North Chatham, NY",
		"North Chili, NY", "North Collins, NY", "North Greece, NY",
		"North Salem, NY", "North Tonawanda, NY", "Northport, NY",
		"Northville, NY", "Norwich, NY", "Norwood, NY", "Nunda, NY", "Nyack, NY",
		"Oakdale, NY", "Oakfield, NY", "Oakland Gardens, NY", "Oceanside, NY",
		"Odessa, NY", "Ogdensburg, NY", "Old Bethpage, NY", "Old Chatham, NY",
		"Old Forge, NY", "Old Westbury, NY", "Olean, NY", "Oneida, NY", "Oneonta, NY",
		"Ontario, NY", "Orangeburg, NY", "Orchard Park, NY", "Oriskany, NY",
		"Ossining, NY", "Oswego, NY", "Ovid, NY", "Owego, NY", "Oxford, NY",
		"Oyster Bay, NY", "Ozone Park, NY", "Painted Post, NY",
		"Palatine Bridge, NY", "Palisades, NY", "Palmyra, NY", "Parishville, NY",
		"Parksville, NY", "Patchogue, NY", "Patterson, NY", "Pawling, NY",
		"Pearl River, NY", "Peekskill, NY", "Pelham, NY", "Penfield, NY",
		"Penn Yan, NY", "Perry, NY", "Phelps, NY", "Phoenix, NY", "Piermont, NY",
		"Pine Bush, NY", "Pine Island, NY", "Pine Plains, NY", "Pittsford, NY",
		"Plainview, NY", "Plattsburgh, NY", "Pleasant Valley, NY",
		"Pleasantville, NY", "Poestenkill, NY", "Point Lookout, NY", "Pomona, NY",
		"Port Chester, NY", "Port Ewen, NY", "Port Jefferson, NY",
		"Port Jefferson Sta, NY", "Port Jefferson Station, NY",
		"Port Jervis, NY", "Port Washington, NY", "Portville, NY", "Potsdam, NY",
		"Poughkeepsie, NY", "Poughquag, NY", "Pound Ridge, NY", "Prattsburgh, NY",
		"Pulaski, NY", "Purchase, NY", "Putnam Valley, NY", "Queens Village, NY",
		"Queensbury, NY", "Randolph, NY", "Ravena, NY", "Red Creek, NY", "Red Hook, NY",
		"Rego Park, NY", "Remsen, NY", "Remsenburg, NY", "Rensselaer, NY",
		"Rexford, NY", "Rhinebeck, NY", "Richfield Springs, NY",
		"Richmond Hill, NY", "Ridgewood, NY", "Riverhead, NY", "Rochester, NY",
		"Rock Hill, NY", "Rockaway Park, NY", "Rockville Centre, NY",
		"Rocky Point, NY", "Rome, NY", "Ronkonkoma, NY", "Roosevelt, NY",
		"Rosedale, NY", "Roseland, NY", "Rosendale, NY", "Roslyn, NY",
		"Roslyn Heights, NY", "Rouses Point, NY", "Roxbury, NY", "Rush, NY",
		"Rushville, NY", "Rye, NY", "Rye Brook, NY", "S Richmond Hl, NY",
		"Sackets Harbor, NY", "Sag Harbor, NY", "Saint Albans, NY",
		"Saint James, NY", "Saint Johnsville, NY", "Salamanca, NY", "Salem, NY",
		"Sands Point, NY", "Saranac Lake, NY", "Saratoga Springs, NY",
		"Saugerties, NY", "Sayville, NY", "Scarsdale, NY", "Schenectady, NY",
		"Schenevus, NY", "Schoharie, NY", "Schuylerville, NY", "Scottsville, NY",
		"Sea Cliff, NY", "Seafor, NY", "Selden, NY", "Seneca Falls, NY",
		"Setauket, NY", "Shelter Island, NY", "Sherburne, NY", "Sherman, NY",
		"Sherrill, NY", "Shirley, NY", "Shoreham, NY", "Shortsville, NY", "Sidney, NY",
		"Silver Creek, NY", "Silver Springs, NY", "Sinclairville, NY",
		"Skaneateles, NY", "Slate Hill, NY", "Sleepy Hollow, NY",
		"Slingerlands, NY", "Smithtown, NY", "Sodu, NY", "Somers, NY",
		"Sound Beach, NY", "South Fallsburg, NY", "South Glens Falls, NY",
		"South Ozone Park, NY", "South Richmond Hill, NY", "South Salem, NY",
		"South Setauket, NY", "Southampton, NY", "Southold, NY", "Sparkill, NY",
		"Speculator, NY", "Spencer, NY", "Spencerport, NY", "Speonk, NY",
		"Spring Valley, NY", "Springfield Gardens, NY", "Springville, NY",
		"Staatsburg, NY", "Stamford, NY", "Stanfordville, NY", "Stanley, NY",
		"Staten Island, NY", "Stephentown, NY", "Stone Ridge, NY",
		"Stony Brook, NY", "Stony Point, NY", "Suffern, NY", "Sugar Loaf, NY",
		"Sunnyside, NY", "Sylvan Beach, NY", "Syosset, NY", "Syracuse, NY",
		"Tallman, NY", "Tannersville, NY", "Tappan, NY", "Tarrytown, NY",
		"Theresa, NY", "Thiells, NY", "Thompson Ridge, NY", "Thornwood, NY",
		"Ticonderoga, NY", "Tivoli, NY", "Tonawanda, NY", "Trinity, NY", "Troy, NY",
		"Trumansburg, NY", "Tuckahoe, NY", "Tully, NY", "Tupper Lake, NY",
		"Tuxedo Park, NY", "Unadilla, NY", "Uniondale, NY", "Utica, NY", "Valatie, NY",
		"Valhalla, NY", "Valley Cottage, NY", "Valley , NY", "Stream, NY",
		"Verbank, NY", "Vernon, NY", "Verplanck, NY", "Vestal, NY", "Victor, NY",
		"Voorheesville, NY", "Waccabuc, NY", "Wading River, NY", "Wainscott, NY",
		"Walden, NY", "Wallkill, NY", "Walton, NY", "Walworth, NY", "Wampsville, NY",
		"Wantagh, NY", "Wappingers Falls, NY", "Warsaw, NY", "Warwick, NY",
		"Washingtonville, NY", "Water Mill, NY", "Waterford, NY", "Waterloo, NY",
		"Watertown, NY", "Waterville, NY", "Watervliet, NY", "Watkins Glen, NY",
		"Waverly, NY", "Wayland, NY", "Webster, NY", "Weedsport, NY", "Wellsville, NY",
		"West Babylon, NY", "West Coxsackie, NY", "West Fulton, NY",
		"West Harrison, NY", "West Haverstraw, NY", "West Hempstead, NY",
		"West Henrietta, NY", "West Islip, NY", "West Monroe, NY",
		"West Nyack, NY", "West Sand Lake, NY", "West Sayville, NY",
		"West Seneca, NY", "West Valley, NY", "West Winfield, NY", "Westbury, NY",
		"Westerlo, NY", "Westfield, NY", "Westhampton, NY",
		"Westhampton Beach, NY", "Westport, NY", "White Plains, NY",
		"Whitehall, NY", "Whitesboro, NY", "Whitestone, NY", "Whitney Point, NY",
		"Williamson, NY", "Williamsville, NY", "Williston Park, NY",
		"Wilmington, NY", "Wilson, NY", "Windham, NY", "Windsor, NY", "Wolcott, NY",
		"Woodbourn, NY", "Woodbur, NY", "Woodhaven, NY", "Woodmere, NY",
		"Woodridge, NY", "Woodside, NY", "Woodstock, NY", "Worcester, NY",
		"Wurtsboro, NY", "Wykagyl, NY", "Wynantskill, NY", "Yaphank, NY",
		"Yonkers, NY", "Yorktown Heights, NY", "Yorkville, NY", "Youngstown, NY"};

	private static ArrayList<String> capitalsList = new ArrayList<String>();

	private static Map<String, String> capitals = 
			new HashMap<String,String>();
	static {
		capitals.put("Abu Dhabi", "United Arab Emirates");
		capitals.put("Abuja", "Nigeria");
		capitals.put("Accra", "Ghana");
		capitals.put("Addis Ababa", "Ethiopia");
		capitals.put("Algiers", "Algeria");
		capitals.put("Amman", "Jordan");
		capitals.put("Amsterdam", "Netherlands");
		capitals.put("Andorra la Vella", "Andorra");
		capitals.put("Ankara", "Turkey");
		capitals.put("Antananarivo", "Madagascar");
		capitals.put("Apia", "Samoa");
		capitals.put("Ashgabat", "Turkmenistan");
		capitals.put("Asmara", "Eritrea");
		capitals.put("Astana", "Kazakhstan");
		capitals.put("Asunción", "Paraguay");
		capitals.put("Athens", "Greece");
		capitals.put("Baghdad", "Iraq");
		capitals.put("Baku", "Azerbaijan");
		capitals.put("Bamako", "Mali");
		capitals.put("Bandar Seri Begawan", "Brunei");
		capitals.put("Bangkok", "Thailand");
		capitals.put("Bangui", "Central African Republic");
		capitals.put("Banjul", "Gambia");
		capitals.put("Basseterre", "Saint Kitts and Nevis");
		capitals.put("Beijing", "People's Republic of China");
		capitals.put("Beirut", "Lebanon");
		capitals.put("Belgrade", "Serbia");
		capitals.put("Belmopan", "Belize");
		capitals.put("Berlin", "Germany");
		capitals.put("Bern", "Switzerland");
		capitals.put("Bishkek", "Kyrgyzstan");
		capitals.put("Bissau", "Guinea-Bissau");
		capitals.put("Bogot", "Colombia");
		capitals.put("Brasília", "Brazil");
		capitals.put("Bratislava", "Slovakia");
		capitals.put("Brazzaville", "Republic of the Congo");
		capitals.put("Bridgetown", "Barbados");
		capitals.put("Brussels", "Belgium");
		capitals.put("Bucharest", "Romania");
		capitals.put("Budapest", "Hungary");
		capitals.put("Buenos Aires", "Argentina");
		capitals.put("Bujumbura", "Burundi");
		capitals.put("Cairo", "Egypt");
		capitals.put("Canberra", "Australia");
		capitals.put("Caracas", "Venezuela");
		capitals.put("Castries", "Saint Lucia");
		capitals.put("Chisinau", "Moldova");
		capitals.put("Conakry", "Guinea");
		capitals.put("Copenhagen", "Denmark");
		capitals.put("Dakar", "Senegal");
		capitals.put("Damascus", "Syria");
		capitals.put("Dhaka", "Bangladesh");
		capitals.put("Dili", "East Timor");
		capitals.put("Djibouti", "Djibouti");
		capitals.put("Dodoma", "Tanzania");
		capitals.put("Doha", "Qatar");
		capitals.put("Dublin", "Ireland");
		capitals.put("Dushanbe", "Tajikistan");
		capitals.put("Freetown", "Sierra Leone");
		capitals.put("Funafuti", "Tuvalu");
		capitals.put("Gaborone", "Botswana");
		capitals.put("Georgetown", "Guyana");
		capitals.put("Guatemala City", "Guatemala");
		capitals.put("Hanoi", "Vietnam");
		capitals.put("Harare", "Zimbabwe");
		capitals.put("Havana", "Cuba");
		capitals.put("Helsinki", "Finland");
		capitals.put("Honiara", "Solomon Islands");
		capitals.put("Islamabad", "Pakistan");
		capitals.put("Jakarta", "Indonesia");
		capitals.put("Jerusalem", "Israel ");
		capitals.put("Kabul", "Afghanistan");
		capitals.put("Kampala", "Uganda");
		capitals.put("Kathmandu", "Nepal");
		capitals.put("Khartoum", "Sudan");
		capitals.put("Kiev", "Ukraine");
		capitals.put("Kigali", "Rwanda");
		capitals.put("Kingston", "Jamaica");
		capitals.put("Kingstown", "Saint Vincent and the Grenadines");
		capitals.put("Kinshasa", "Democratic Republic of the Congo");
		capitals.put("Kuala Lumpur", "Malaysia");
		capitals.put("Kuwait City", "Kuwait");
		capitals.put("La Paz", "Bolivia");
		capitals.put("Libreville", "Gabon");
		capitals.put("Lilongwe", "Malawi");
		capitals.put("Lima", "Peru");
		capitals.put("Lisbon", "Portugal");
		capitals.put("Ljubljana", "Slovenia");
		capitals.put("Lom", "Togo");
		capitals.put("London", "United Kingdom");
		capitals.put("Luanda", "Angola");
		capitals.put("Lusaka", "Zambia");
		capitals.put("Luxembourg City", "Luxembourg");
		capitals.put("Madrid", "Spain");
		capitals.put("Majuro", "Marshall Islands");
		capitals.put("Malabo", "Equatorial Guinea");
		capitals.put("Mal", "Maldives");
		capitals.put("Managua", "Nicaragua");
		capitals.put("Manama", "Bahrain");
		capitals.put("Manila", "Philippines");
		capitals.put("Maputo", "Mozambique");
		capitals.put("Maseru", "Lesotho");
		capitals.put("Mbabane", "Swaziland");
		capitals.put("Mexico City", "Mexico");
		capitals.put("Minsk", "Belarus");
		capitals.put("Mogadishu", "Somalia");
		capitals.put("Monaco", "Monaco");
		capitals.put("Monrovia", "Liberia");
		capitals.put("Montevideo", "Uruguay");
		capitals.put("Moroni", "Comoros");
		capitals.put("Moscow", "Russia");
		capitals.put("Muscat", "Oman");
		capitals.put("Nairobi", "Kenya");
		capitals.put("Nassau", "Bahamas");
		capitals.put("Naypyidaw", "Myanmar");
		capitals.put("N'Djamena", "Chad");
		capitals.put("New Delhi", "India");
		capitals.put("Melekeok", "Palau");
		capitals.put("Niamey", "Niger");
		capitals.put("Nicosia", "Cyprus");
		capitals.put("Nouakchott", "Mauritania");
		capitals.put("Nuku\'alofa", "Tonga");
		capitals.put("Oslo", "Norway");
		capitals.put("Ottawa", "Canada");
		capitals.put("Ouagadougou", "Burkina Faso");
		capitals.put("Palikir", "Federated States of Micronesia");
		capitals.put("Panama City", "Panama");
		capitals.put("Paramaribo", "Suriname");
		capitals.put("Paris", "France");
		capitals.put("Phnom Penh", "Cambodia");
		capitals.put("Podgorica", "Montenegro");
		capitals.put("Port Louis", "Mauritius");
		capitals.put("Port Moresby", "Papua New Guinea");
		capitals.put("Port Vila", "Vanuatu");
		capitals.put("Port-au-Prince", "Haiti");
		capitals.put("Port of Spain", "Trinidad and Tobago");
		capitals.put("Porto-Novo", "Benin");
		capitals.put("Prague", "Czech Republic");
		capitals.put("Praia", "Cape Verde");
		capitals.put("Pretoria", "South Africa");
		capitals.put("Putrajaya", "Malaysia");
		capitals.put("Pyongyang", "North Korea");
		capitals.put("Quito", "Ecuador");
		capitals.put("Rabat", "Morocco");
		capitals.put("Reykjavík", "Iceland");
		capitals.put("Riga", "Latvia");
		capitals.put("Riyadh", "Saudi Arabia");
		capitals.put("Rome", "Italy");
		capitals.put("Roseau", "Dominica");
		capitals.put("San Jos", "Costa Rica");
		capitals.put("San Juan", "Puerto Rico");
		capitals.put("San Marino", "San Marino");
		capitals.put("San Salvador", "El Salvador");
		capitals.put("Sana", "Yemen");
		capitals.put("Santiago", "Chile");
		capitals.put("Santo Domingo", "Dominican Republic");
		capitals.put("STom", "STomand Príncipe");
		capitals.put("Sarajevo", "Bosnia and Herzegovina");
		capitals.put("Seoul", "South Korea");
		capitals.put("Singapore", "Singapore");
		capitals.put("Skopje", "Macedonia");
		capitals.put("Sofia", "Bulgaria");
		capitals.put("South Tarawa", "Kiribati");
		capitals.put("Sri Jayawardenepura", "Sri Lanka");
		capitals.put("St. George\'s", "Grenada");
		capitals.put("St. John\'s", "Antigua and Barbuda");
		capitals.put("Stockholm", "Sweden");
		capitals.put("Sucre", "Bolivia");
		capitals.put("Suva", "Fiji");
		capitals.put("Taipei", "Republic of China (Taiwan)");
		capitals.put("Tallinn", "Estonia");
		capitals.put("Tashkent", "Uzbekistan");
		capitals.put("Tbilisi", "Georgia");
		capitals.put("Tegucigalpa", "Honduras");
		capitals.put("Tehran", "Iran");
		capitals.put("Thimphu", "Bhutan");
		capitals.put("Tirana", "Albania");
		capitals.put("Tokyo", "Japan");
		capitals.put("Tripoli", "Libya");
		capitals.put("Tunis", "Tunisia");
		capitals.put("Ulaanbaatar", "Mongolia");
		capitals.put("Vaduz", "Liechtenstein");
		capitals.put("Valletta", "Malta");
		capitals.put("Vatican City", "Vatican City");
		capitals.put("Victoria", "Seychelles");
		capitals.put("Vienna", "Austria");
		capitals.put("Vientiane", "Laos");
		capitals.put("Vilnius", "Lithuania");
		capitals.put("Warsaw", "Poland");
		capitals.put("Washington, D.C.", "United States");
		capitals.put("Wellington", "New Zealand");
		capitals.put("Windhoek", "Namibia");
		capitals.put("Yamoussoukro", "Côte d\'Ivoire");
		capitals.put("Yaound", "Cameroon");
		capitals.put("Yaren", "Nauru");
		capitals.put("Yerevan", "Armenia");
		capitals.put("Zagreb", "Croatia");
		capitalsList.addAll(capitals.keySet());
	}
}

