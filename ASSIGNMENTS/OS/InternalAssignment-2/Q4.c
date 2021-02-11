#include<stdio.h>
#include<unistd.h>
#include <fcntl.h>
#include<pthread.h>


int main()
{

	pid_t pid;

        int isSuccess = mkfifo("mypipe",O_CREAT | 0777);

	if (isSuccess < 0)
	{
		printf("mkfifo command failed\n");
		return -1;
	}

	pid = fork();
	
	if (pid < 0)
	{
		printf("Process failed\n");
		return -2;
	}
	
	for(int i=0;i<5;i++)
	{	

		if(pid>0)
		{	
			printf("From parent...scaning...\n");


			int fd=open("mypipe",O_WRONLY);
			int number=i+1;
			write(fd,&number,sizeof(number));

			close(fd);
			sleep(1);
	
		}

		else
		{	
			printf("From child...printing...");
		
			int number;
			int fd=open("mypipe",O_RDONLY);
			read(fd,&number,sizeof(number));
			printf("%d",number);
			printf("\n");
			close(fd);
	
		}
	}

	if(pid==0)
	{
		execl("/bin/mkdir","mkdir","data",NULL);
	}


	return 0;

}


