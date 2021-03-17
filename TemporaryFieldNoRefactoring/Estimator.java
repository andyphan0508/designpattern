public class Estimator {
    
    private TimeSpan defaultEstimate;
    public Estimator(TimeSpan defaultEstimate) {
        this.defaultEstimate = this.defaultEstimate;
    }
    public final TimeSpan CalculateEstimate(IReadOnlyCollection<TimeSpan> durations) {
        if ((durations == null)) {
            throw new ArgumentNullException(nameof(durations));
        }
        
        if ((durations.Count == 0)) {
            return this.defaultEstimate;
        }
        
        var stats = new DurationStatistics(durations);
        var margin = TimeSpan.FromTicks((stats.StandardDeviation.Ticks * 3));
        return (stats.Average + margin);
    }
    
    private class DurationStatistics {
    
        private IReadOnlyCollection<TimeSpan> durations; 
        private Lazy<TimeSpan> average;
        private Lazy<TimeSpan> standardDeviation;
        
        public DurationStatistics(IReadOnlyCollection<TimeSpan> durations) {
            if ((this.durations == null)) {
                throw new ArgumentNullException(nameof(this.durations));
            }
            
            if ((this.durations.Count == 0)) {
                throw new ArgumentException("Empty collection not allowed.", nameof(this.durations));
            }
            
            this.durations = this.durations;
            this.average = new Lazy<TimeSpan>(this.CalculateAverage);
            this.standardDeviation = new Lazy<TimeSpan>(this.CalculateStandardDeviation);
        }
        
        public final TimeSpan Average {
                return this.average.Value;
        }
        
        public final TimeSpan StandardDeviation {            
                return this.standardDeviation.Value;
        }
        
        private final TimeSpan CalculateAverage() {
            return TimeSpan.FromTicks(((long)(this.durations.Average(() => {  }, ts.Ticks))));
        }
        
        private final TimeSpan CalculateStandardDeviation() {
            var variance = this.durations.Average(() => {  }, Math.Pow((ts - this.average.Value).Ticks, 2));
            return TimeSpan.FromTicks(((long)(Math.Sqrt(variance))));
        }
    }
}