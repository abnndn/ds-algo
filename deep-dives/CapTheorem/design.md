[Reference youtube video](https://www.youtube.com/watch?v=VdrEq0cODu4)

### CAP Theorem in System Design Interviews

------------------------------------------------------------------------

What is CAP Theorem?
You can only have 2 out of 3.
1. Consistency - all nodes/users see the same data at the same time.
2. Availability - every request gets a response (successful or not).
3. Partition tolerance - system works despite network failures b/w nodes.

------------------------------------------------------------------------

why does this matter?
- Important to define the system architecture early during non-functional requirements.
- They influence the design decisions during deep dives.

------------------------------------------------------------------------

Now note that "partition tolerance" in a distributed system is a must. 
so, we've chosen 1 out of the 3 already.

The only question is - do I prioritize "Availability" or "Consistency".

Next question is, why do I even need to choose b/w the 2.

Example:
`UserA ---write---> USA Server <---replicate---> Europe Server <---read--- UserB.`

say, the replicate operation fails for some reason.
and UserB comes to read, there are 2 options here:
1. STOP serving data (Consistency)
2. OR risk wrong data (Availability)

Examples where we choose option 1:
1. Ticket booking platform (airline, event etc). 
   - If we sell the ticket, everyone needs to see it as unavailable, without delay.
2. Inventory system (Amazon). 
   - Can't sell the same last item to multiple customers. (debatable)
3. Financial systems. 
   - Stock trades must be executed in strict order. So pricing can be managed.

Examples where we choose option 2: (overwhelming majority of cases)
1. social media app.
2. Yelp like business review service.
3. Streaming server like Netflix.

------------------------------------------------------------------------

How does it influence the design?

#### Strong consistency:
* implement distributed transactions.
* OR limit to a single node.
* discuss consensus protocols.
* accept higher latency.
* Example tools
  - PostGreSQL
  - Trad RDBMS
  - Spanner (offered by google)
  - NoSQL with strong consistency mode (DDB)

TODO: read about the above tools.

#### Availability:
* use multiple replicas.
* CDC and eventual consistency is OK.
* Example tools.
  - DynamoDB (in multi-AZ moe)
  - Cassandra

TODO: read about the above tools.

------------------------------------------------------------------------

#### Advanced!

Different parts of the system can have different requirements.

* TicketMaster is 1 of the examples:
  * Availability during lookup, CRUD on events.
  * Consistency during ticket booking.

* Tinder is another example:
  * Availability for viewing profile data.
  * Consistency for matching.

------------------------------------------------------------------------

# Different types of Consistency

1. Strong Consistency: all reads reflect most recent writes.
2. Causal Consistency: related events appear in order. Ex: order of comments.
3. Read-your-writes Consistency: User sees their own updates.
4. Eventual Consistency: Updates will propagate eventually.
   * This is what we'll have if prioritizing Availability.
