[Reference youtube video](https://www.youtube.com/watch?v=fODT0ldeBiU)

### Low-Level Design Interview: Design an Elevator w/ a Ex-Meta Staff Engineer
https://www.hellointerview.com/learn/low-level-design/problem-breakdowns/elevator

------------------------------------------------------------------------------------------

### Question: <br>
Design an elevator control system for a building, The system should handle multiple elevators, floor requests,
and move elevators efficiently to service requests. 

Roadmap/Framework for any lld (low level design) interview: <br>
1. Requirements
2. Entities
3. Class Design
4. Implementation [Some companies prefer pseudo-code]
5. Extensibility

------------------------------------------------------------------------------------------

**Requirements:** <br>

Ask questions and confirmations:
1. Primary capabilities.
   2. How many elevators and floors> Fixed or configurable? 
      3. [5 elevator, 10 floors, fixed]
   3. Are Hall calls just up and down or they choose a floor? 
      4. [up and down]
   4. Can passengers select multiple destination floors inside the elevator? 
      5. [Yes]
      6. Two Types of elevator stops [Hall calls, destination, ideal] 
   5. The problem says cars should "move efficiently", what does that mean?
      6. [I'll let you define it.]
   6. System habdles multiple concurrent pickup requests across floors.


2. Error handling.
   3. What about invalid floors?
      4. [throw error]
   4. What is someone requests the floor they're already on?
      5. [No Op]
3. Scope boundaries.
   4. Capacity, weight limits, door mechanics, emergency stops.
   5. Simulation (step/tick) or actual hardware control software.
      6. [Let's focus on simulation] - [Almost always simulation.]

------------------------------------------------------------------------------------------

**Entities:** <br>

- Elevator (Class)
  - maintains state, current floor, direction, which floor to stop.
- Floor (Number)
- Request (Class)
  - need direction and potentially the floor.
  - hall call, destination.
- ElevatorController (Class)
  - It's orchestrator, for the simulation.

------------------------------------------------------------------------------------------

**Class Design:** <br>

```
class ElevatorController:
    - elevators: List<Elevator>
    
    + ElevatorController()
    + requestElevator(floor, direction) -> boolean
    + steps() -> void
```    
    
```
class Elevator:
    - currentFloor: Int
    - direction: Direction
    - requests: Set<Request> // handle deduplication.
    
    + Elevator()
    + addRequests(request) -> boolean
    + step() -> void
    + getFloor() -> Int
    + getDirection() -> Direction
    
enum Direction:
    UP
    DOWN
    IDLE
```

```
# 1. hall call: Floor + direction
# 2. Destination: floor
class Request:

    - floor: int
    - type: RequestType

    + Request(floor, type)
    + getFloor() -> Int
    + getType() -> RequestType

enum RequestType:
    PICKUP_UP
    PICKUP_DOWN
    DESTINATION
```

------------------------------------------------------------------------------------------

**Implementation:** <br>

- Define the core logic.
- Consider the edge cases.

```
ElevatorController.kt
```

```
Elevator.kt    
```


------------------------------------------------------------------------------------------

**Extensibility:** <br>

1. What if multiple hall calls come in at the same time? what if a hall call comes in while step is running?
2. How would you add priority floors or an express elevator?
3. How would you add the ability to cancel a floor request?

Starting with 1:
What if multiple hall calls come in at the same time? what if a hall call comes in while step is running?
* Database, class mutation (add requests, removing requests) need to be thread safe.

TODO: Need to read about thread-sage queue and locking in kotlin

Option 1: Locking <br>
```
requestElevator(floor, type)
    lock.acquire()
    ...
    lock.release()
    
step()
    lock.acquire()
    ...
    lock.release()
```
Working solution but it slows down the system.

[Recommended] Option 2: Thread-safe queue<br>
```
addRequests(request):
    pendingRequest.enqueue(request) //thread-safe queue. each langauge has one.
    
step():
    while !pendingRequests.isEmpty()
        activeRequests.add(pendingRequests.dequeue())
        // all logic uses activeRequests
        ....
```

Checking out 2:
How would you add priority floors or an express elevator?
* 1 option is to add priority to the request object, but that'll mess up the step function (the scan algorithm we wrote).
* another option is to make 1 of the lifts as express lifts.

```
class Elevator:
    isExpress: boolean
    priorityFloors: [2, 5, 9]
```

Checking out 3:
How would you add the ability to cancel a floor request?

```
    removeRequests(request)
        lock.acquire()
        requests.remove(request)
        lock.release()
```

-----------------------------------------------------------------------------

