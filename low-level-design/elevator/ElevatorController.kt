package elevator

import kotlin.math.abs

class ElevatorController(
    val totalFloors: Int,
    val elevators: List<Elevator>) {

    constructor(totalFloors: Int, numElevators: Int) : this(
        totalFloors,
        List(numElevators) { Elevator() }
    )

    fun step() {
        for (e in elevators) {
            e.step()
        }
    }

    fun requestElevator(floor: Int, type: RequestType) {
        require(floor in 0 until totalFloors) {
            "Floor $floor out of range"
        }
        require(type != RequestType.DESTINATION) {
            "DESTINATION is not a valid hall call"
        }

        val request = Request(floor, type)
        val bestElevator: Elevator = selectBestElevator(request)

        bestElevator.addRequest(request)
    }

    private fun selectBestElevator(request: Request): Elevator {
        // Can use strategy pattern here, so different mechanisms can be used.
        // Based on developer and elevator system, they can choose any.
        // Round-Robin, Direction aware, Nearest.

        // Core logic:
        // Try to find the elevator moving toward
        // if none, try idle elevators (nearest), pick the nearest

        var best: Elevator? = null
        best = findMovingToward(request)
        if (best != null) {
            return best
        }

        best = findNearestIdle(request)
        if (best != null) {
            return best
        }

        return findNearest(request)
    }

    private fun findMovingToward(request: Request): Elevator? {
        var elevator: Elevator? = null
        var minDistance: Int = Int.MAX_VALUE

        for (e in elevators) {
            val requestDirection = when (request.type) {
                RequestType.UP -> Direction.UP
                RequestType.DOWN -> Direction.DOWN
                RequestType.DESTINATION -> return null  // or throw
            }
            if (e.direction != requestDirection) continue

            if (e.direction == Direction.UP && e.currentFloor > request.floor ||
                e.direction == Direction.DOWN && e.currentFloor < request.floor) {
                continue
            }

            val currDistance = abs(e.currentFloor - request.floor)
            if (currDistance < minDistance) {
                minDistance = currDistance
                elevator = e
            }
        }

        return elevator
    }

    private fun findNearestIdle(request: Request): Elevator? {
        var elevator: Elevator? = null
        var minDistance: Int = Int.MAX_VALUE

        for (e in elevators) {
            if (e.direction != Direction.IDLE) {
                continue
            }

            val currDistance = abs(e.currentFloor - request.floor)
            if (currDistance < minDistance) {
                minDistance = currDistance
                elevator = e
            }
        }
        return elevator
    }

    private fun findNearest(request: Request): Elevator {
        var elevator: Elevator? = null
        var minDistance: Int = Int.MAX_VALUE

        for (e in elevators) {
            val currDistance = abs(e.currentFloor - request.floor)
            if (currDistance < minDistance) {
                minDistance = currDistance
                elevator = e
            }
        }

        if (elevator == null) {
            elevator = elevators[0]
        }

        return elevator
    }
}