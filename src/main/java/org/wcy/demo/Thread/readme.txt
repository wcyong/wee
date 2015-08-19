notify
public final void notify()
	唤醒在此对象监视器上等待的单个线程。如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。选择是任意性的，并在对实现做出决定时发生。
	线程通过调用其中一个wait 方法，在对象的监视器上等待。
	直到当前的线程放弃此对象上的锁定，才能继续执行被唤醒的线程。被唤醒的线程将以常规方式与在该对象上主动同步的其他所有线程进行竞争；
	例如，唤醒的线程在作为锁定此对象的下一个线程方面没有可靠的特权或劣势。
	此方法只应由作为此对象监视器的所有者的线程来调用。通过以下三种方法之一，线程可以成为此对象监视器的所有者：
	通过执行此对象的同步 (Sychronized) 实例方法。
	通过执行在此对象上进行同步的 synchronized 语句的正文。
	对于 Class 类型的对象，可以通过执行该类的同步静态方法。
	一次只能有一个线程拥有对象的监视器。
	抛出：
	IllegalMonitorStateException - 如果当前的线程不是此对象监视器的所有者。
	
	
notifyAll
public final void notifyAll()
	唤醒在此对象监视器上等待的所有线程。线程通过调用其中一个 wait 方法，在对象的监视器上等待。
	直到当前的线程放弃此对象上的锁定，才能继续执行被唤醒的线程。被唤醒的线程将以常规方式与在该对象上主动同步的其他所有线程进行竞争；
	例如，唤醒的线程在作为锁定此对象的下一个线程方面没有可靠的特权或劣势。
	此方法只应由作为此对象监视器的所有者的线程来调用。请参阅 notify 方法，了解线程能够成为监视器所有者的方法的描述。
	抛出：
	IllegalMonitorStateException - 如果当前的线程不是此对象监视器的所有者。
	

wait
public final void wait(long timeout)
                throws InterruptedException
	导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或notifyAll() 方法，或者超过指定的时间量。
	当前的线程必须拥有此对象监视器。
	此方法导致当前线程（称之为 T）将其自身放置在对象的等待集中，然后放弃此对象上的所有同步要求。
	出于线程调度目的，线程 T 被禁用，且处于休眠状态，直到发生以下四种情况之一：
	其他某个线程调用此对象的 notify 方法，并且线程 T 碰巧被任选为被唤醒的线程。
	其他某个线程调用此对象的 notifyAll 方法。
	其他某个线程中断线程 T。
	已经到达指定的实际时间。但是，如果 timeout 为零，则不考虑实际时间，该线程将一直等待，直到获得通知。
	然后，从对象的等待集中删除线程 T，并重新进行线程调度。然后，该线程以常规方式与其他线程竞争，以获得在该对象上同步的权利；
	一旦获得对该对象的控制权，该对象上的所有其同步声明都将被还原到以前的状态 - 这就是调用wait 方法时的情况。
	然后，线程T 从wait 方法的调用中返回。所以，从wait 方法返回时，该对象和线程T 的同步状态与调用wait 方法时的情况完全相同。
	在没有被通知、中断或超时的情况下，线程还可以唤醒一个所谓的虚假唤醒 (spurious wakeup)。
	虽然这种情况在实践中很少发生，但是应用程序必须通过以下方式防止其发生，即对应该导致该线程被提醒的条件进行测试，
	如果不满足该条件，则继续等待。换句话说，等待应总是发生在循环中，如下面的示例：
	synchronized (obj) {
	while (<condition does not hold>)
	obj.wait(timeout);
	... // Perform action appropriate to condition
	     }
	 
	如果当前线程在等待时被其他线程中断，则会抛出InterruptedException。在按上述形式恢复此对象的锁定状态时才会抛出此异常。
	注意，由于 wait 方法将当前的线程放入了对象的等待集中，所以它只能解除此对象的锁定；可以同步当前线程的任何其他对象在线程等待时仍处于锁定状态。
	此方法只应由作为此对象监视器的所有者的线程来调用。请参阅 notify 方法，了解线程能够成为监视器所有者的方法的描述。
	参数：
	timeout - 要等待的最长时间（以毫秒为单位）。
	抛出：
	IllegalArgumentException - 如果超时值为负。
	IllegalMonitorStateException - 如果当前的线程不是此对象监视器的所有者。
	InterruptedException - 如果在当前线程等待通知之前或者正在等待通知时，另一个线程中断了当前线程。在抛出此异常时，当前线程的中断状态 被清除。
	
	
wait
public final void wait(long timeout,
                       int nanos)
                throws InterruptedException
	导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或notifyAll() 方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量。
	此方法类似于一个参数的 wait 方法，但它允许更好地控制在放弃之前等待通知的时间量。用毫微秒度量的实际时间量可以通过以下公式计算出来：
	1000000*timeout+nanos
	在其他所有方面，此方法执行的操作与带有一个参数的 wait(long) 方法相同。需要特别指出的是，wait(0, 0) 与wait(0) 相同。
	当前的线程必须拥有此对象监视器。该线程发布对此监视器的所有权，并等待下面两个条件之一发生：
	其他线程通过调用 notify 方法，或 notifyAll 方法通知在此对象的监视器上等待的线程醒来。
	timeout 毫秒值与 nanos 毫微秒参数值之和指定的超时时间已用完。
	然后，该线程等到重新获得对监视器的所有权后才能继续执行。
	对于某一个参数的版本，实现中断和虚假唤醒是有可能的，并且此方法应始终在循环中使用：
	synchronized (obj) {
	while (<condition does not hold>)
	obj.wait(timeout, nanos);
	... // Perform action appropriate to condition
	     }
	 
	此方法只应由作为此对象监视器的所有者的线程来调用。请参阅 notify 方法，了解线程能够成为监视器所有者的方法的描述。
	参数：
	timeout - 要等待的最长时间（以毫秒为单位）。
	nanos - 额外时间（以毫微秒为单位，范围是 0-999999）。
	抛出：
	IllegalArgumentException - 如果超时值是负数，或者毫微秒值不在 0-999999 范围内。
	IllegalMonitorStateException - 如果当前线程不是此对象监视器的所有者。
	InterruptedException - 如果在当前线程等待通知之前或者正在等待通知时，其他线程中断了当前线程。在抛出此异常时，当前线程的中断状态 被清除。
	

wait
public final void wait()
                throws InterruptedException
	导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或notifyAll() 方法。换句话说，此方法的行为就好像它仅执行wait(0) 调用一样。
	当前的线程必须拥有此对象监视器。该线程发布对此监视器的所有权并等待，直到其他线程通过调用 notify 方法，或 notifyAll 
	方法通知在此对象的监视器上等待的线程醒来。然后该线程将等到重新获得对监视器的所有权后才能继续执行。
	对于某一个参数的版本，实现中断和虚假唤醒是可能的，而且此方法应始终在循环中使用：
	synchronized (obj) {
	while (<condition does not hold>)
	obj.wait();
	... // Perform action appropriate to condition
	     }
	 
	此方法只应由作为此对象监视器的所有者的线程来调用。请参阅 notify 方法，了解线程能够成为监视器所有者的方法的描述。
	抛出：
	IllegalMonitorStateException - 如果当前的线程不是此对象监视器的所有者。
	InterruptedException - 如果在当前线程等待通知之前或者正在等待通知时，另一个线程中断了当前线程。在抛出此异常时，当前线程的中断状态 被清除。 
	