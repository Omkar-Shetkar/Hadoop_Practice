import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class AlphabetCountReducer extends
		Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {

	@Override
	protected void reduce(IntWritable key, Iterable<IntWritable> value,
			Context context) throws IOException, InterruptedException {
		int count = 0;
		for (IntWritable i : value) {
			count += i.get();
		}
		context.write(key, new IntWritable(count));
	}
}
