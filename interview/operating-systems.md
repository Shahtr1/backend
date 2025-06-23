## Operating Systems

❓ 100 Operating Systems Interview Questions
🧠 Processes, Threads & Scheduling (Q1–Q20)
What is the difference between a process and a thread?

How are threads managed in Java?

What is a context switch?

What are the different types of thread scheduling?

Explain preemptive vs cooperative multitasking.

What is a process control block?

What are thread pools and why are they used?

How does Java handle thread priorities?

What is a daemon thread?

How does the OS allocate CPU to threads?

Explain user mode vs kernel mode.

How are child processes created in Linux?

What are long-term, short-term, and medium-term schedulers?

What is the difference between CPU-bound and I/O-bound processes?

How is thread scheduling different on multi-core CPUs?

What is starvation in process scheduling?

What is the difference between fork and exec?

What is a race condition?

How does round-robin scheduling work?

What are zombie and orphan processes?

🔐 Synchronization & Deadlocks (Q21–Q40)
What is a critical section?

What are the conditions for deadlock?

How do semaphores work?

What is a monitor in Java?

Difference between mutex and semaphore?

What is a reentrant lock?

How does Java’s synchronized keyword work?

How can deadlock be avoided?

What is livelock?

What is priority inversion?

How does the Banker’s algorithm work?

What is spinlock? When would you use it?

What are busy-wait and blocking wait?

How do you debug a deadlock?

What’s the difference between pessimistic and optimistic locking?

How does wait() and notify() work in Java?

What is the producer-consumer problem?

What is a barrier in concurrent programming?

What are reader-writer locks?

How would you prevent race conditions?

🧠 Memory Management & Virtual Memory (Q41–Q65)
What is virtual memory?

Explain the difference between heap and stack memory.

What is paging vs segmentation?

What is demand paging?

What are page faults?

What is the TLB (Translation Lookaside Buffer)?

What is internal and external fragmentation?

How does garbage collection work in Java?

What is compaction?

What is a memory leak?

How do you analyze memory usage in a Java process?

What are memory-mapped files?

What is shared memory?

Explain swapping in and out.

What is the role of the MMU?

What is copy-on-write?

How do you measure the memory footprint of a thread?

Explain stack overflow and heap overflow.

What is segmentation fault?

How is memory managed in containers (e.g., Docker)?

🧾 File Systems, I/O & Storage (Q66–Q80)
What is a file descriptor?

What’s the difference between buffered and unbuffered I/O?

How does the OS schedule disk I/O?

What are inodes in Linux?

Explain file locking mechanisms.

How do journaling file systems work?

What is direct memory access (DMA)?

What is memory-mapped I/O?

How do SSDs and HDDs affect performance?

What is a device driver?

What are hard links vs soft links?

How does the OS manage file permissions?

What is the difference between sequential and random access?

How is file metadata stored?

What is a mount point?

What are block devices vs character devices?

What is the role of the page cache in file reads?

What are superblocks?

What is fsync and why is it needed?

How would you build a custom file system?

📡 Inter-Process Communication & Signals (Q81–Q100)
What are the different IPC mechanisms?

How do pipes work?

How do message queues work?

What is shared memory and when to use it?

How do sockets enable IPC?

What is a signal in Unix/Linux?

What is a signal handler?

How do you handle SIGKILL vs SIGTERM?

What are named pipes (FIFOs)?

How does RPC (remote procedure call) work?

What are lightweight processes?

How does mmap enable communication between processes?

How do you debug IPC deadlocks?

How do you broadcast a signal to all threads?

What is select/poll/epoll?

What’s the difference between blocking and non-blocking I/O?

How do you achieve zero-copy data transfer?

What is latency vs throughput in IPC?

When would you use a message bus?

How is IPC handled in containers?

💡 Java Example – Deadlock Scenario
java
Copy
Edit
class A {
synchronized void methodA(B b) {
System.out.println("Thread1: Holding A and waiting for B");
b.last();
}

    synchronized void last() {
        System.out.println("Inside A.last()");
    }

}

class B {
synchronized void methodB(A a) {
System.out.println("Thread2: Holding B and waiting for A");
a.last();
}

    synchronized void last() {
        System.out.println("Inside B.last()");
    }

}
