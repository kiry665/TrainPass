SELECT s.name, arrival_time, departure_time FROM routes AS r
JOIN stations s on s.id = r.station_id
WHERE train_id = 1
ORDER BY sequence_number;

EXPLAIN ANALYZE
SELECT s1.name, s2.name, t.train_number, t.type, r1.departure_time, r2.arrival_time
FROM routes r1
JOIN routes r2 ON r1.train_id = r2.train_id
JOIN trains t ON r1.train_id = t.id
JOIN stations s1 ON r1.station_id = s1.id
JOIN stations s2 ON r2.station_id = s2.id
WHERE r1.station_id = 1
  AND r2.station_id = 5
  AND r1.sequence_number < r2.sequence_number;



