import java.util.Scanner;

class Position {
    public int x;
    public int y;

    Position() {
        this.x = 0;
        this.y = 0;
    }

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Rover {
    public Rover(String name, Position startAt) {
        this.name = name;
        this.position = startAt;
        this.moving = false;
    }

    @Override
    public String toString() {
        return "Rover " + this.name + " --> (" + this.position.x + ", " + this.position.y + ")";
    }

    public void goForward() {
        moving = true;
    }

    public void stop() {
        moving = false;
    }

    public void update(char azimuth) {
        if(moving) {
            if(azimuth == 'N') {
                if(Rover.this.position.y - 1 >= 0) {
                    Rover.this.position.y--;
                } else {
                    Rover.this.position.y = 10;
                }
            } else if(azimuth == 'S') {
                if(Rover.this.position.y + 1 <= 10) {
                    Rover.this.position.y++;
                } else {
                    Rover.this.position.y = 0;
                }
            } else if(azimuth == 'E') {
                if(Rover.this.position.x - 1 >= 10) {
                    Rover.this.position.x--;
                } else {
                    Rover.this.position.x = 10;
                }
            } else if(azimuth == 'W') {
                if(Rover.this.position.x + 1 <= 10) {
                    Rover.this.position.x++;
                } else {
                    Rover.this.position.x = 0;
                }
            }
        } else {
            System.out.println("Start engine to move...");
        }
    }

    private String name;
    private Position position;
    private boolean moving;
}


public class Main {
    public static void main(String[] argv) {
        System.out.println("-------- Mars Rover --------");
        Rover walle = new Rover("Wall-E", new Position(2, 2));
        Scanner in = new Scanner(System.in);
        int menu = 0;

        do {
            System.out.println(walle);

            System.out.println("What now?");
            System.out.println("1. North");
            System.out.println("2. South");
            System.out.println("3. East");
            System.out.println("4. West");
            System.out.println("5. Start Engine");
            System.out.println("6. Stop");
            System.out.println("7. Exit");
            System.out.println(">>> ");
            menu = in.nextInt();

            switch (menu) {
                case 1:
                    walle.update('N');
                    break;
                case 2:
                    walle.update('S');
                    break;
                case 3:
                    walle.update('E');
                    break;
                case 4:
                    walle.update('W');
                    break;
                case 5:
                    walle.goForward();
                    System.out.println("Engine start...");
                    break;
                case 6:
                    walle.stop();
                    System.out.println("Engine stop...");
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Wrong value!");

            }

        } while (menu != 7);
    }
}
