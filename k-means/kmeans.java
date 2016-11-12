import java.io.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class kmeans {
	public static void main(String[] args) {
		
		int check = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the value of k :");							//Enter the number of clusters
		int k = in.nextInt();
		ArrayList<ArrayList<String>> cluster = new ArrayList<>();				//Holds the different clusters
		for (int i = 0; i < k; i++) {
			cluster.add(new ArrayList<>()); 									//Creating k clusters
		}
		int theta = 0;
		String fileName = "C:\\Users\\Venkat\\Desktop\\deltaclean2.txt";		//Please provide the correct file path here.
		ArrayList<ArrayList<String>> dataItemstotal = new ArrayList<>();
		ArrayList<String> dataItems = new ArrayList<String>();
	
		for (int i = 0; i < 699; i++) {
			dataItemstotal.add(new ArrayList<>());								//Initializing
		}

		String line = null;
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);		
		
			while ((line = bufferedReader.readLine()) != null) {
				dataItems.add(line);											//Adds each line from the dataset to the list

			}
			System.out.println("dataItems size: " + dataItems.size());

			for (int m = 0; m < dataItems.size(); m++) {
				dataItems.get(0);
				dataItemstotal.get(m).add(dataItems.get(m));					//Add all the sub lists to the main list

			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");		//Handling file not found exceptions
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}

		Random rand = new Random();
		int[][] centroids = new int[k][8];
		System.out.println("Random centroids");
		for (int l = 0; l < k; l++) { 											//Creating randomized centroids
			for (int n = 0; n < 8; n++) {
				centroids[l][n] = rand.nextInt(10) + 1;
				System.out.print(centroids[l][n] + "\t");
			}
			System.out.println("\n");
		}

		for (int w = 0; w < 20 || theta < 0; w++) {  /*running 20 iterations or if the threshold is met, which ever happens first...*/
			cluster.clear();
			for (int i = 0; i < k; i++) {
				cluster.add(new ArrayList<>()); 								//Creating k clusters
			}

			int[][] d2 = new int[k][8]; 										//Storing the difference in d2.
			System.out.println("Caluclating the distances..");

			for (int a = 0; a < 699; a++) { 									//Accessing the 699 data items..
				String x = dataItemstotal.get(a).get(0);   /*gets the data from each sub list as a string..*/

				for (int b = 0; b < k; b++) {  /* to access the first k individual elements (x1, y1)of each sub list..*/
					int no = 0;
					StringTokenizer st = new StringTokenizer(x);

					/* accessing based on comma separation, and converting
					 from string to int, finding the difference and storing in array*/
					while ((no < 8) && (st.hasMoreElements())) {
						String y = (String) st.nextElement();
						int z = Integer.parseInt(y);
						int d1 = (z - centroids[b][no]);
						d2[b][no] = d1;
						no++;
					}
				}

				int sq1 = 0;
				int minnew = Integer.MAX_VALUE;
				int centroidcount = -1;
				for (int d4 = 0; d4 < d2.length; d4++) {
					int dd1 = d2[d4][0];
					int dd2 = d2[d4][1];
					int dd3 = d2[d4][2];
					int dd4 = d2[d4][3];
					int dd5 = d2[d4][4];
					int dd6 = d2[d4][5];
					int dd7 = d2[d4][6];
					int dd8 = d2[d4][7];

					sq1 = ((dd1 * dd1) + (dd2 * dd2) + (dd3 * dd3) + (dd4 * dd4) + (dd5 * dd5) + (dd6 * dd6) + (dd8*dd8) + (dd7 * dd7));

					double output = Math.sqrt(sq1);

					if (output < minnew) {									//Checking the centroid whic is closest to the data point
						minnew = (int) output;
						centroidcount = d4;
					}
				}

				cluster.get(centroidcount).add(dataItems.get(a));			//Adding the data point to the respective cluster
			}

			for (int x = 1; x <= k; x++) {
				System.out.println("Cluster " + x + ":" + cluster.get(x - 1));
				int z = cluster.get(x - 1).size();
				//System.out.println(z);
			}

			int centroidsnew[][] = new int[k][8];
			System.out.println("New centroid values");						//Caluclating the new centroid values based on the average in each cluster
			for (int f = 0; f < k; f++) {
				int size = cluster.get(f).size();
				int sum1 = 0;
				int sum2 = 0;
				int sum3 = 0;
				int sum4 = 0;
				int sum5 = 0;
				int sum6 = 0;
				int sum7 = 0;
				int sum8 = 0;
				int[] sum = new int[8];
				int[] avg = new int[8];
				for (int i = 0; i < size; i++) {
					String z = cluster.get(f).get(i);
					int no1 = 0;
					int no2 = 0;
					StringTokenizer st = new StringTokenizer(z);

					while ((no1 < 8) && (st.hasMoreElements())) {
						String yy = (String) st.nextElement();
						if (no2 == 0) {
							int zzz = Integer.parseInt(yy);
							sum1 = sum1 + zzz;
							sum[no2] = sum1;
						} else if (no2 == 1) {
							int zzz = Integer.parseInt(yy);
							sum2 = sum2 + zzz;
							sum[no2] = sum1;
						} else if (no2 == 2) {
							int zzz = Integer.parseInt(yy);
							sum3 = sum3 + zzz;
							sum[no2] = sum3;
						} else if (no2 == 3) {
							int zzz = Integer.parseInt(yy);
							sum4 = sum4 + zzz;
							sum[no2] = sum4;
						} else if (no2 == 4) {
							int zzz = Integer.parseInt(yy);
							sum5 = sum5 + zzz;
							sum[no2] = sum5;
						} else if (no2 == 5) {
							int zzz = Integer.parseInt(yy);
							sum6 = sum6 + zzz;
							sum[no2] = sum6;
						} else if (no2 == 6) {
							int zzz = Integer.parseInt(yy);
							sum7 = sum7 + zzz;
							sum[no2] = sum7;
						} else if (no2 == 7) {
							int zzz = Integer.parseInt(yy);
							sum8 = sum8 + zzz;
							sum[no2] = sum8;
						}
						no2++;
						no1++;
					}
				}
				
				for (int d = 0; d < 7; d++) {
					avg[d] = sum[d] / size;
				}

				for (int p = 0; p < 8; p++) {
					centroidsnew[f][p] = avg[p];
					System.out.print(centroidsnew[f][p] + "\t");
				}
				System.out.println();
			}

			int[][] centroidscal = new int[k][8];
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < 8; j++) {

					centroidscal[i][j] = (centroids[i][j] - centroidsnew[i][j]);
					centroids[i][j] = centroidsnew[i][j];							//Assigning new centroid values to old centroid
				}
			}
			theta = 0;
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < 8; j++) {
					centroidscal[i][0] = centroidscal[i][0] + centroidscal[i][j];	//Calculating the threshold based on the centroid values
				}
				
				theta = theta + centroidscal[i][0];
				check++;
			}
		}

		for (int i = 0; i < k; i++) {
			int x = cluster.get(i).size();
			System.out.println("Last cluster size: " + x);
		}
		double totalerror = 0;
		for (int i = 0; i < k; i++) {												//Calculating the error rates
			int x = cluster.get(i).size();
			System.out.println("Size" + x);
			int malign = 0;
			int benign = 0;
			for (int j = 0; j < x; j++) {
				String u = cluster.get(i).get(j);
				int n = 0;
				StringTokenizer st = new StringTokenizer(u);
				while ((n < 9) && st.hasMoreElements()) {
					String y = (String) st.nextElement();
					if (n == 8) {													//Getting the sum of class values
						int z = Integer.parseInt(y);
						if (z == 2) {
							benign++;
						} else if (z == 4) {				
							malign++;
						}
					}
					n++;
				}
			}
			double error = 0;
			System.out.println("Malign sum: " + malign);
			System.out.println("Benign sum: " + benign);
			if (benign > malign) {
				error = (double) malign / (double) (benign + malign);				// benign > malign
			} else {
				error = (double) benign / (double) (malign + benign);				// malign > benign
			}
			System.out.println("Error for cluster" + i + " :" + error);
			totalerror = totalerror + error;
			
		}
		System.out.println("Total error: " + totalerror);
	}
}
