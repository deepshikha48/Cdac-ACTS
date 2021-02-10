#include<stdio.h>
#include<pthread.h>
#include<semaphore.h>

//declaring global array and semaphore variable
int arr[5];
sem_t s;

void *writeToArray()
{
	printf("Writing to array....\n");	
	sem_wait(&s);

	for(int i=0;i<5;i++)
	{
		printf("Enter number to store: \n");
		scanf("%d",&arr[i]);

	}

	sem_post(&s);
}

//will execute after writeToarray() because of semaphore
void *readFromArray()
{
	sleep(1);
	sem_wait(&s);	
	printf("Reading from array....\n");
	
	for(int i=0;i<5;i++)
	{
		printf("%d\t",arr[i]);
	
	}

	sem_post(&s);

}

//Driver function
int main()
{
	pthread_t  tid1,tid2;
	
	sem_init(&s,0,1);  // initializing semaphore
	
	// two threads created
	pthread_create(&tid1,NULL,writeToArray,NULL);
	pthread_create(&tid2,NULL,readFromArray,NULL);
	// main() will wait for threads to join
	pthread_join(tid1,NULL);
	pthread_join(tid2,NULL);


	sem_destroy(&s); // destroy semaphore

	return 0;


}
