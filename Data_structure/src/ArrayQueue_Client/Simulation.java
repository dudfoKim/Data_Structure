package ArrayQueue_Client;

public class Simulation {

	static int numServers;
	static int numClients;
	static int meanServiceTime;
	static int meanInterarrivalTime;
	static int nextArrivalTime = 0;
	static Server[] servers;
	static Client[] clients;
	static ArrayQueue queue;
	static java.util.Random randomArrival;
	static java.util.Random randomService;
	static int arrivalTime[];
	static int finishTime[];

	public static void main(String[] args) {
		init(args);
		serve();
	}
	
	private static void getAverageTime(){
		int avg = 0, totaltime = 0;
		for(int i = 0; i < clients.length; i++){
			totaltime += (finishTime[i] - arrivalTime[i]); 
		}
		avg = totaltime / numClients;
		System.out.println("Ŭ���̾�Ʈ�� ������ �� ���� �ޱ⸦ ������ ������ �ɸ��� ��սð� : " + avg);
	}

	private static void serve() {
		int nextClient = 0, finishClient = 0;
		
		for (int t = 0; ; t++) {			
			if (t == nextArrivalTime) {
				
				arrivalTime[nextClient] = t; //���۽ð��� �迭�� ����
				
				Client client = clients[nextClient++] = new SimClient(nextClient, t);
				queue.add(client);
				if (nextClient < numClients)
					nextArrivalTime = t + randomArrival.nextInt();
			}
			for (int j = 0; j < numServers; j++) {
				Server server = servers[j];
				if (t == server.getStopTime()) {
					server.stopServing(t);					
				}
				if (server.isIdle() && !queue.isEmpty()) {
					Client client = (SimClient) queue.remove();
					server.startServing(client, t);
					finishTime[finishClient++] = servers[j].getStopTime(); //������ �ð��� �迭�� ����
				}
			}
			if (nextClient >= numClients && allServersIdle() == true) {
				getAverageTime();
				System.out.println("Exit");
				break;
			}
		}
	}

	private static void init(String[] args) {
		if (args.length < 4) {   //args�� ������ �� �Էµ��� �ʾ�����
			System.out.println("Usage: java Simulation <numServers> "
					+ " <numClients> <meanServiceTime> <meanInterarrivalTime>");
			System.out.println(" e.g.: java Simulation 3 100 12 4");
			System.exit(0);
		}
		
		//��ü, �迭, ť �ʱ�ȭ
		numServers = Integer.parseInt(args[0]);
		numClients = Integer.parseInt(args[1]);
		meanServiceTime = Integer.parseInt(args[2]);
		meanInterarrivalTime = Integer.parseInt(args[3]);
		servers = new Server[numServers];
		clients = new Client[numClients];
		randomService = new ExponentialRandom(meanServiceTime);
		randomArrival = new ExponentialRandom(meanInterarrivalTime);
		queue = new ArrayQueue();
		arrivalTime = new int [Integer.parseInt(args[1])];
		finishTime = new int [Integer.parseInt(args[1])];
		
		//���� �ð��� ���� sever ��ü���� �����ؼ� servers[]�� ����
		for (int j = 0; j < numServers; j++) {
			//servers[j] = new SimServer(j, randomService.nextInt());
			servers[j] = new SimServer(j, (j + 1) * meanServiceTime);
		}

		System.out.println("\t\tNumber of servers = " + numServers);  //���� ����
		System.out.println("\t\tNumber of clients = " + numClients);  //Ŭ���̾�Ʈ ����
		System.out.println("\t\tMean service time = " + meanServiceTime);  
		System.out.println("\t\tMean interarrival time = " + meanInterarrivalTime);

		for (int j = 0; j < numServers; j++) {
			System.out.println("Mean service time for " + servers[j] + " = " + servers[j].getMeanServiceTime());
		}
	}

	private static boolean allServersIdle() {
		for (Server s : servers) {
			if (s.isIdle() != true)
				return false;
		}
		return true;
	}
}