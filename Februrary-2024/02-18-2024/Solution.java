import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) ->  a[0] - b[0]);
        int[] rooms = new int[n];
       PriorityQueue<Room> pq_a = new PriorityQueue<>((a,b) -> {
           if(a.end != b.end) {
               return a.end - b.end;
           }
           else {
               return a.room - b.room;
           }
       });

       PriorityQueue<Room> pq_u = new PriorityQueue<>((a,b) -> {
           if(a.end != b.end) {
               return a.end - b.end;
           }
           else {
               return a.room - b.room;
           }
       });
        for(int i=0;i<n;i++) {
            pq_a.add(new Room(i,0));
        }
       for(int i=0;i<meetings.length;i++) {
           while(pq_u.size() > 0) {
               if(pq_u.peek().end <= meetings[i][0]) {
                   pq_a.add(new Room(pq_u.peek().room, 0));
                   pq_u.poll();
               }
               else {
                   break;
               }
           }
           if(pq_a.size() > 0) {
               Room r = pq_a.poll();
               rooms[r.room]++;
               pq_u.add(new Room(r.room, meetings[i][1]));
           }
           else {
               Room r = pq_u.poll();
               rooms[r.room]++;
               pq_u.add(new Room(r.room, r.end+(meetings[i][1] - meetings[i][0])));
           }
       }
       int max_room = -1;
       int max_val = -1;
        for(int i=0;i<rooms.length;i++) {
            if(max_val < rooms[i]) {
                max_room = i;
                max_val = rooms[i];
            }
        }
        return max_room;
    }
}

class Room {
    int room;
    int end;
    Room(int room, int end) {
        this.room = room;
        this.end = end;
    }
}