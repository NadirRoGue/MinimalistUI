package net.minimal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Nadir Román Guerrero
 */
public final class ThreadPool
{
	private static final class Singleton
	{
		static final ThreadPool INSTANCE = new  ThreadPool();
	}
	
	public static ThreadPool getInstance()
	{
		return Singleton.INSTANCE;
	}
	
	private final ThreadPoolExecutor executor;
	private final ThreadPoolExecutor effectsExecutor;
	private final ScheduledThreadPoolExecutor scheduler;
	
	ThreadPool()
	{
		executor = new  ThreadPoolExecutor(2, 2, 1500L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		effectsExecutor = new  ThreadPoolExecutor(2, 4, 3000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		scheduler = new ScheduledThreadPoolExecutor(4);
	}
	
	public void execute(Runnable r)
	{
		executor.execute(r);
	}
	
	public void executeEffect(Runnable r)
	{
		effectsExecutor.execute(r);
	}
	
	public void schedule(Runnable r, long delayMilis)
	{
		//ScheduledFuture<?> futureTask =
		scheduler.schedule(r, delayMilis, TimeUnit.MILLISECONDS);
	}
}
