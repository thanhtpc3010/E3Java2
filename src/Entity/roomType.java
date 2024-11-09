package Entity;

public enum roomType {

        S("Single"),D("Double"),Qe("Queen"),T("Triple"),Q("Quad");
        private String roomTypeLabel;
        roomType(String roomTypeLabel){
            this.roomTypeLabel = roomTypeLabel;
        }
        public String getRoomTypeLabel() {
            return roomTypeLabel;
        }
        public void setRoomTypeLabel(String roomTypeLabel) {
            this.roomTypeLabel = roomTypeLabel;
        }
    }


