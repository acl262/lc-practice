select w1.id 
from weather w1, weather w2
where w1.recorddate = w2.recorddate +1 and w1.Temperature > w2.temperature
