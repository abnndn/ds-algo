package elevator

import kotlin.math.abs

class Elevator(
    var currentFloor: Int = 0,
    var direction: Direction = Direction.IDLE,
    var requests: MutableSet<Request> = mutableSetOf()) {

    fun addRequest(request: Request) {
        requests.add(request)
    }

    fun step() {
        // Core Logic:
        // Uses a SCAN logic for elevator movement.
        // If idle, pick the direction towards the nearest request.
        // Check if we stop at the current floor (hall call or destination).
        // If no requests ahead of us and request are pending, reverse.
        // Move 1 floor in the current direction.

        // Edge cases:
        // No requests -> set IDLE return
        // STOP and MOVE can't happen in same tick.
        // REVERSE and MOVE can't happen in same tick.

        if (requests.isEmpty()) {
            direction = Direction.IDLE
            return
        }

        var nearest: Request? = null

        if (direction == Direction.IDLE) {
            nearest = findNearestRequest()
            if (nearest != null) {
                direction =
                    if (nearest.floor > currentFloor)
                        Direction.UP
                    else
                        Direction.DOWN
            }
        }

        val type: RequestType =
            if (direction == Direction.UP)
                RequestType.UP
            else
                RequestType.DOWN

        val hallCallRequest = Request(currentFloor, type)
        val destinationRequest = Request(currentFloor, RequestType.DESTINATION)

        if (requests.contains(hallCallRequest) || requests.contains(destinationRequest)) {
            requests.remove(hallCallRequest)
            requests.remove(destinationRequest)
            stop()
            return
        }

        if (!hasRequestsAhead(direction)) {
            direction =
                if (direction == Direction.UP)
                    Direction.DOWN
                else
                    Direction.UP

            return
        }

        if (direction == Direction.UP)
            currentFloor += 1
        else if (direction == Direction.DOWN)
            currentFloor -= 1
    }

    private fun findNearestRequest(): Request? {
        var nearest: Request? = null
        var minDistance = Integer.MAX_VALUE

        for (req in requests) {
            val distance = abs(req.floor - currentFloor)
            if (distance < minDistance) {
                minDistance = distance
                nearest = req
            }
        }

        return nearest
    }

    private fun stop() {
        direction = Direction.IDLE
    }

    private fun hasRequestsAhead(dir: Direction): Boolean {
        for (request in requests) {
            if (dir == Direction.UP && request.floor > currentFloor)
                return true
            if (dir == Direction.DOWN && request.floor < currentFloor)
                return true
        }
        return false
    }
}