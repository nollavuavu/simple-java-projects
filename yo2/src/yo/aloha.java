package yo;
import java.util.Random;

public class aloha {
	public static void main(String[] args) {
		int[] playerDeal = new int[21];
		int[] botDeal = new int[21];
		
		int wincount = 0, losecount = 0;
		
		while (true) {
			addCard(botDeal);
			addCard(botDeal);
			addCard(playerDeal);
			addCard(playerDeal);
			
			while (true) {
				System.out.println("Bot's cards: " + botDeal[0]);
				printPlayerDeal(playerDeal);
				String choice = NirajTools.getInput("hit or stand?(H|S)").toLowerCase();
				if (choice.equals("h")) {
					if (total(playerDeal)> 21) {
						System.out.println("You cannot hit with that hand");
					}
					else {
						addCard(playerDeal);
						printPlayerDeal(playerDeal);
						botThink(botDeal, playerDeal);
					}
				}
				
				else if (choice.equals("s")) {
					botThink(botDeal,playerDeal);
					if (((total(playerDeal) > 21) || (total(botDeal)>21)) || (total(botDeal)<22 && total(botDeal) >= 17)) {
						break;
					}
				}
			}
			int bottotal = total(botDeal);
			int playertotal = total(playerDeal);
			
			printBotDeal(botDeal);
			if (((bottotal > playertotal) && (bottotal < 22) && (playertotal < 22)) || (playertotal > 21) || (bottotal == playertotal)) {
				losecount++;
				System.out.println("You lost to the bot. Win: "+wincount+", Lose: "+losecount);
			}

			else if (playertotal == bottotal && playertotal < 22){
				System.out.println("It's a draw!");
			}
				
			else {
				wincount++;
				System.out.println("You defeated the bot. Win: "+wincount+", Lose: "+losecount);
			}
			refresh(botDeal, playerDeal);
			System.out.println();
		}
	}
	
	public static int draw() {
		Random rand = new Random();
		return rand.nextInt(11) + 1;
	}
	
	public static void printPlayerDeal(int[] playerDeal) {
		String deal = "";
		for (int i = 0; i < playerDeal.length; i++) {
			if (playerDeal[i] == 0) {
				continue;
			}
			deal += playerDeal[i]+" ";
		}
		System.out.println("Your cards are "+deal+ "with total: "+total(playerDeal));
	}
	
	public static void printBotDeal(int[] botDeal) {
		String deal = "";
		for (int i = 0; i < botDeal.length; i++) {
			if (botDeal[i] == 0) {
				continue;
			}
			deal += botDeal[i]+" ";
		}
		System.out.println("Bot's cards are "+deal + "with total: "+total(botDeal));
	}
	
	public static void addCard(int[] deal) {
		for (int i = 0; i < deal.length; i++) {
			if (deal[i] == 0) {
				deal[i] = draw();
				break;
			}
		}
	}
	
	public static int total(int[] deal) {
	    int sum = 0;
	    for (int i = 0; i < deal.length; i++) {
	        sum = sum + deal[i];
	    }
	    return sum;
	}
	
	public static void botThink(int[] botDeal, int[] playerDeal) {
		int bot = total(botDeal);
		int player = total(playerDeal);
		
	    if ((bot >= 21) || (player >= 21)) {
	    	System.out.println("The bot stands");
	    	return;
	    }
	    else if ((bot < 17) || (bot <player)) {
	    	addCard(botDeal);
	    	System.out.println("The bot has hit");
	    }
	}
	
	public static void refresh(int[] bot, int[] player) {
		for (int i = 0; i < bot.length; i++) {
			bot[i] = 0;
			
		}
		for (int i = 0; i < player.length; i++) {
			player[i] = 0;
			
		}
	}
}
