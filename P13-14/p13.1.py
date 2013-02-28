def initialization:
    semaphore swimmer1 = swimmer1.init(0)
    semaphore swimmer2 = swimmer2.init(0)
    swimmer1.wait()
    swimmer2.wait()

def firstSwimmer:
    swim()
    swimmer1.signal()

def secondSwimmer:
    swimmer1.wait()
    swim()
    swimmer2.signal()
    
def thirdSwimmer:
    swimmer2.wait()
    swim()

