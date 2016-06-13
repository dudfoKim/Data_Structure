package ArrayQueue_Client2;

public class Simulation {

	static int numServers;
	static int numClients;
	static int meanServiceTime;
	static int meanInterarrivalTime;
	static int nextArrivalTime = 0;
	static Server[] servers;
	static Client[] clients;
	static ArrayQueue queue1;
	static ArrayQueue queue2;
	static ArrayQueue queue3;
	static java.util.Random randomArrival;
	static java.util.Random randomService;
	static int arrivalTime1[];
	static int finishTime1[];
	static int arrivalTime2[];
	static int finishTime2[];
	static int arrivalTime3[];
	static int finishTime3[];
	static ArrayQueue [] queues;

	public static void main(String[] args) {
		init(args);
		serve();
	}
	
	private static void getAverageTime(){
		int avg = 0, totaltime = 0;
		for(int i = 0; i < clients.length; i++){
			totaltime += (finishTime1[i] - arrivalTime1[i]); 
			totaltime += (finishTime2[i] - arrivalTime2[i]); 
			totaltime += (finishTime3[i] - arrivalTime3[i]); 
		}
		avg = totaltime / numClients;
		System.out.println("Ŭ���̾�Ʈ�� ������ �� ���� �ޱ⸦ ������ ������ �ɸ��� ��սð� : " + avg);
	}

	private static void serve() {
		int nextClient = 0;
		int finishedClient1 = 0, finishedClient2 = 0, finishedClient3 = 0;
		
		for (int t = 0; ; t++) {			
			if (t == nextArrivalTime) {
				Client client = clients[nextClient++] = new SimClient(nextClient, t);
				
				int a = queue1.size();
				int b = queue2.size();
				int c = queue3.size();
				
				if(a <= b && a <= c){
					queue1.add(client);
					arrivalTime1[nextClient-1] = t; //���۽ð��� �迭�� ����
				}else if(b <= a && b <= c){
					queue2.add(client);
					arrivalTime2[nextClient-1] = t; //���۽ð��� �迭�� ����
				}else if(c <= a && c <= b){
					queue3.add(client);
					arrivalTime3[nextClient-1] = t; //���۽ð��� �迭�� ����
				}
				
				if (nextClient < numClients)
					nextArrivalTime = t + randomArrival.nextInt();
			}
			
			
				Server server1 = servers[0];
				if (t == server1.getStopTime()) {
					server1.stopServing(t);
					
				}
				if (server1.isIdle() && !queue1.isEmpty()) {   //������ ����ְ� ť�� Ŭ���̾�Ʈ�� ���� ��
					Client client = (SimClient) queue1.remove();
					server1.startServing(client, t); 
					finishTime1[finishedClient1++] = servers[0].getStopTime(); //������ �ð��� �迭�� ����
				}				
				Server server2 = servers[1];
				if (t == server2.getStopTime()) {
					server2.stopServing(t);
				}
				if (server2.isIdle() && !queue2.isEmpty()) {   //������ ����ְ� ť�� Ŭ���̾�Ʈ�� ���� ��
					Client client = (SimClient) queue2.remove();
					server2.startServing(client, t);
					finishTime2[finishedClient2++] = servers[1].getStopTime(); //������ �ð��� �迭�� ����
				}			
				Server server3 = servers[2];
				if (t == server3.getStopTime()) {
					server3.stopServing(t);
				}
				if (server3.isIdle() && !queue3.isEmpty()) {   //������ ����ְ� ť�� Ŭ���̾�Ʈ�� ���� ��
					Client client = (SimClient) queue3.remove();
					server3.startServing(client, t); 
					finishTime3[finishedClient3++] = servers[2].getStopTime(); //������ �ð��� �迭�� ����
				}
			if (nextClient >= numClients && allServersIdle() == true) { //���α׷� ����
				getAverageTime();
				System.out.println("Exit");
				break;
			}
		}
	}

	private static void init(String[] args) {
		if (args.length < 4) {   //args�� ������ �� �Էµ��� �ʾ�����
			System.out.println("Usage: java Simulation <numServers> <numClients> <meanServiceTime> <meanInterarrivalTime>");
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
		queue1 = new ArrayQueue();
		queue2 = new ArrayQueue();
		queue3 = new ArrayQueue();
		arrivalTime1 = new int [Integer.parseInt(args[1])];
		finishTime1 = new int [Integer.parseInt(args[1])];
		arrivalTime2 = new int [Integer.parseInt(args[1])];
		finishTime2 = new int [Integer.parseInt(args[1])];
		arrivalTime3 = new int [Integer.parseInt(args[1])];
		finishTime3 = new int [Integer.parseInt(args[1])];
		
		//���� �ð��� ���� sever ��ü���� �����ؼ� servers[]�� ����
		for (int j = 0; j < numServers; j++) {
			servers[j] = new SimServer(j, randomService.nextInt());
			//servers[j] = new SimServer(j, (j + 1) * meanServiceTime);
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