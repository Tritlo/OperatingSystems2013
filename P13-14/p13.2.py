Showers.init(2)
Shower1Free = True
ShowerFree.init(1)

def Shower():
    Showers.wait()
    ShowerFree.wait()
    #Note that as Showers.wait() guarantees that only two can shower at the same time, either Shower 1 is free or not, and if it is not free, then Shower 2 is.
    if Shower1Free:
        Shower1Free = False
        ShowerFree.signal()
        takeShower(1)
        ShowerFree.wait()
        Shower1Free = True
        ShowerFree.signal()
        Showers.signal()
    else:
        takeShower(2)
        ShowerFree.signal()
        Showers.signal()
